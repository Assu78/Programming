public class Istumapaikka {

	protected int riivi; 
	protected int paikka;

	public Istumapaikka(int riivi, int paikka){
		this.riivi = riivi; 
		this.paikka = paikka;
	}

	public void asetaRiivi(int riivi){
		this.riivi = riivi;
	}
	
	public int annaRiivi(){
		return riivi;
	}
	
	public void asetaPaikka(int paikka){
		this.paikka = paikka;
	}
	
	public int annaPaikka(){
		return paikka;
	}
	
	public String toString() {
		 return "riivi: " + riivi + ", paikka: " + paikka;
	}	 
}
