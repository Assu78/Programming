import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class XpalveluidenHallinta extends Thread{
	private Xpalvelu[] palvelut;
	private ArrayList<ArrayList<Integer>> saadutluvut;
	ServerSocket serverSocket;
	UDPViesti udpmsg = new UDPViesti();

	//main metodi
	public static void main(String[] args) throws SocketException, IOException, EOFException{
		XpalveluidenHallinta hallinta = new XpalveluidenHallinta();
		hallinta.start();
	}
//portti = omaportti
	/** lähetetään Y-palvelimelle UDP viesti, jossa lukee portin numero,  ja johon Y-palvelin yhdistää Xpalvelun kanssa
	*	jos Xpalvelu ei saa viestiä viidessä sekunnissa, niin se lähettää UDP viestin uudestaan Y-palvelimelle
	*	viidennen yhteysyrityksen jälkeen Xpalvelu lopettaa ja sulkee sovelluksen
	*	@param osoite viestin kohdeosoite (IP)
	*	@param portti käytettävä yhteysportti
	*	@param portti1 toinen käytettävä yhteysportti
	 */
	private Socket luoYhteys(int portti, String osoite, int portti1)throws IOException{
		Socket socket = null; 	//alustet	an soketti
		serverSocket = new ServerSocket(portti);	//luodaan uusi soketti


		for(int i=0; i< 5; i++){
			try{
				serverSocket.setSoTimeout(5000);	//asetetaan timeout millisekunteina
				udpmsg.sendUDP(osoite, portti, Integer.toString(portti));	//luodaan UDP viesti
				System.out.println(i+1 + "yhteysyritys...");
				socket =serverSocket.accept();
				break;
			}catch(SocketTimeoutException ioe){
				if(i == 4){	//yhteysyritysten määrä
					System.out.println("Yhteyttä ei muodostunut. Suljetetaan sovellusta.");
					System.exit(0);
				}
			}
		}
		return socket;
	}



	public void run() {
		try{

			Socket cs =  luoYhteys(3126, "localhost", 3126);
			//ottaa vastaan  viestin mikä saapuu Y-palvelimelta
			InputStream input = cs.getInputStream();
			ObjectInputStream oInput = new ObjectInputStream(input);
			// lähetetään Y-palvelimelle
			OutputStream output = cs.getOutputStream();
			ObjectOutputStream oOutput  = new ObjectOutputStream(output);

			int lukumaara =0;
			// jos Xpalvelu ei saa viestiä viidessä sekunnissa niin
			// ohjelma heittää SockettimeExceptionin ja lähettää Y-plavelimelle viestissä (-1)
			// X-palvelu saa varmistuksen viestissä Y-palvelulta montako porttia avataaan
			try{
				cs.setSoTimeout(5000);
				lukumaara = oInput.readInt();
			}catch(SocketTimeoutException e1){
				oOutput.writeInt(-1);
				System.exit(0);

			}

			palvelut = new Xpalvelu[lukumaara]; 	//vastaanotettujen lukujen määrä

			saadutluvut = new ArrayList<ArrayList<Integer>>(lukumaara);	//lista joka sisältää vastaanotetut luvut

				//lisätään vastaanotetut luvut listaan
			for (int i=0; i< lukumaara ;i++ ) {
				palvelut[i] = new Xpalvelu(i, 2001+i, this);
				saadutluvut.add(new ArrayList<Integer>());
				
			}
				//kÄYNNISTÄÄ PORTIT
			for(int i=0; i< lukumaara; i++){
				palvelut[i].start();
			}
				//lähettä outputY-pavlvelimelle
			for (int i=0;i<lukumaara; i++) {
				oOutput.writeInt(2001+i);
				oOutput.flush();
				
			}
			/** jos in = 1, niin Xpalvelu lähettää Ypalvelimelle summan
			*	jos in = 2, niin Xpalvelu lähettää Ypalvelimelle viestissä suurimman summan
			*	jos in = 3, niin Xpalvelu lähettä Ypalvelimelle lukujen lukumäärän
			* 	muuuten lähetetään (-1) ja suljetaan portti
			*/
			while(true){
				try{
				int  in= oInput.readInt();
				if(in == 1){
					annaXpalvelijoilleAikaa();
					oOutput.writeInt(annaSumma());
						System.out.println("Eniten summannutta kysytty: " + annaSumma());
				}else if(in == 2){
					annaXpalvelijoilleAikaa();
					oOutput.writeInt(suurimmanXPalvelu());

				}else if(in ==3){
					annaXpalvelijoilleAikaa();
					System.out.println("Lukujen määrä pyydetty: " + lukujenMaara());
					oOutput.writeInt(lukujenMaara());
				}else{
					oOutput.writeInt(-1);
					System.out.println("Suletetaan sovellusta...");
					//suljeXpalvelut();
					cs.close();
					suljeXpalvelut();
					break;
				}

				oOutput.flush();
				}catch(EOFException ie){
					ie.printStackTrace();

				}
				catch(IOException e){
					e.printStackTrace();

				}
			}

			for (int i=0;i< palvelut.length ;i++ ) {
				try{
					palvelut[i].join();

				}catch(InterruptedException e){
					e.printStackTrace();
				}
				
			}
			System.exit(0);



		}catch(IOException e){
			System.err.print(e.toString());
		}
	}

	public void annaXpalvelijoilleAikaa(){
		for (int i =0;i < palvelut.length ;i++ ) {
			try{
				palvelut[i].join(0,1);

			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
	}
	//sulke kaikki portit
	public void suljeXpalvelut() throws IOException, SocketException{
		for (int i=0;i< palvelut.length ;i++ ) {
			palvelut[i].suljeYhteys();
			
		}
	}
	//
	private int lukujenMaara(){
		int lukumaara = 0;
		for(int i=0; i< annaSaadutLuvut().size(); i++){
			lukumaara = lukumaara + annaSaadutLuvut().get(i).size();

		}
		return lukumaara;

	}

		//etsi kai suurin arvo 
	private int suurimmanXPalvelu(){
		int[] summat = new int[annaSaadutLuvut().size()];

		for (int i=0;i<annaSaadutLuvut().size() ; i++) {
			for (int j = 0;j<annaSaadutLuvut().get(i).size() ;j++ ) {
				summat[i] = summat[i] + annaSaadutLuvut().get(i).get(j);
				
			}
			
		}
		 int suurinIndeksi = 0;
		for (int i=0;i<summat.length ;i++ ) {
			if(summat[suurinIndeksi] < summat[i]){
				suurinIndeksi = i;
			}			
		}
		return suurinIndeksi+1;
	}
	// Summa kaikki porttien arvot
	public int annaSumma(){
		int summa = 0;
		for (int i=0; i< annaSaadutLuvut().size() ;i++ ) {
			for (int j=0;j<annaSaadutLuvut().get(i).size() ;j++ ) {
				summa = annaSaadutLuvut().get(i).get(j) + summa;
				
			}
			
		}
		return summa;

	}

	//lisää Y-plavelimelta tulevia arvoja tietyn indeksii
	

	public boolean lisaaLuku(int indeksi,int luku){
		if(luku == 0){
			return false;
		}
		annaSaadutLuvut().get(indeksi).add(luku);
		System.out.println(indeksi + ".Xpalvelu lisäsi luvun " + luku);
		return true;
	}
	public ArrayList<ArrayList<Integer>> annaSaadutLuvut(){
		return saadutluvut;

	}



}