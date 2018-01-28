public class Asiakas{
	protected String nimi; 
	protected String puhelinnumero;
	protected String sahkoposti;
	protected Elokuva elokuva;
	 
	
	public Asiakas(String nimi, String puhelinnumero, String sahkoposti, Elokuva elokuva){
		this.nimi = nimi;
		this.puhelinnumero = puhelinnumero;
		this.sahkoposti = sahkoposti;
		this.elokuva = elokuva;
		
	 }
	  
	 public void asetaNimi(String nimi){
		 this.nimi = nimi;
	 }
	 
	 public void asetaElokuva(Elokuva elokuva){
		 this.elokuva = elokuva;
	}
	
	 public void asetaPuhelinnumero(String puhelinnumero){
		 this.puhelinnumero = puhelinnumero;
	 }

	 public void asetaSakoposti(String sahkoposti){
		  this.sahkoposti = sahkoposti;
	 }

	 public String annaNimi(){
		 return nimi;
	 }

	 public String annaPuhelinnumero(){
		 return puhelinnumero;
	 }

	 public String annaSahkoposti(){
		 return sahkoposti;
	 }
	 
	 public Elokuva annaElokuva(){
		 return elokuva; 
}
	 
	 
}
