import java.io.*;
import java.net.*;


public class Xpalvelu extends Thread{
	//luokkamuuttujat
	private int index;
	private boolean onYhteys;
	private Socket socket;
	private ServerSocket serverSocket;
	private XpalveluidenHallinta hallinta;


	/**
	 * Konstruktori
	 * @param index palveluidenhallinnalle lähetettävä indexi
	 * @param port kommunikointiin käytettävän portin numero
	 * @param hallinta käytetään yhteyden käynnistämiseen ja katkaisemiseen
	 */

	public Xpalvelu(int index, int port, XpalveluidenHallinta hallinta)throws IOException{

		super();
		this.index = index;
		onYhteys  = false;
		this.hallinta = hallinta;
		serverSocket = new ServerSocket(port);
		socket = null;

	}
	public void run(){
		try{
			socket = serverSocket.accept();
			onYhteys = true;
				// ottaa vastaan viestejä Y-palvelimelta
			InputStream input = socket.getInputStream();
			ObjectInputStream in = new ObjectInputStream(input);
			//jos Y-palvelin ei lähetä viestiä niin soketti sulkeutuu
				//heittää Exceptionin jos tulee jokin ongelma
			while(onYhteys){
				if(!hallinta.lisaaLuku(index, in.readInt())){
					suljeYhteys();
					break;
				}

			}
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println(index + ". palvelu on sujettu!");

	}
	/** Tämä metodi sulkee lopuksi yhteyden Y-palvelimeen
	  * onyhteys = false;
	  */
	public void suljeYhteys(){
		try{
			socket.close();

		}catch(IOException e){
			e.printStackTrace();
		}
		onYhteys = false;
	}
}