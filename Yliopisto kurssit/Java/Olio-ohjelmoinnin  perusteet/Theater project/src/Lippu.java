import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Lippu{
	protected Asiakas asiakas;
	protected Istumapaikka instumaPaikka; 
	protected String paiva; 
	
	public Lippu (Asiakas asiakas, Istumapaikka instumaPaikka, String paiva){
		this.asiakas = asiakas;
		this.instumaPaikka = instumaPaikka; 
		this.paiva = paiva;
		writeToFile(asiakas.annaNimi(), asiakas.annaPuhelinnumero(), asiakas.annaSahkoposti(), asiakas.annaElokuva(), instumaPaikka, paiva);
	}
	
	public void asetaAsiakas(Asiakas asiakas){
		this.asiakas = asiakas;
	}
	
	public void asetaIstumaPaikka(Istumapaikka istumaPaikka){
		this.instumaPaikka = istumaPaikka;
		
	}
	public void asetaIstumaPaikka(String paiva){
		this.paiva = paiva;
		
	}
	
	public Istumapaikka annaIstumaPaikka(){
		return instumaPaikka;
	}
	
	public static void writeToFile(String nimi, String puhelinnumero, String sahkoposti, Elokuva elokuva, Istumapaikka instumaPaikka, String paiva){
	    FileWriter fw = null;
	    PrintWriter pw = null;
	    try{
	       File file = new File("output.txt");
	       if (file.createNewFile()){
	            System.out.println("File is created!");
	          }else{
	            System.out.println("Lippu on tehty");
	          }
	      fw = new FileWriter ("output.txt",true);
	      pw = new PrintWriter(fw);
	      pw.println("Päivä : "+paiva);
	      pw.println("Asiakkaan nimi: "+nimi);
	      pw.println("Puhelinnumero  : "+puhelinnumero);
	      pw.println("Sähköpostin osoite  : "+sahkoposti);
	      pw.println("Elokuvan nimi  : "+ elokuva);
	      pw.println("Valittu paikka  : "+ instumaPaikka);
	      pw.println();
	      pw.flush();
	      pw.close();
	      fw.close();
	    }catch(IOException ioex){}
	  }

}
