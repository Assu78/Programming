package demo2;

public class Lukuvuosi {

	private Periodi[] periodit = new Periodi[5];
	private String lukuvuosi; 
	
	public Lukuvuosi(String tunnus) {
		this.lukuvuosi = tunnus;
	}

	public String getLukuvuosi() {
		return lukuvuosi;
	}

	/**
	 * Hakee annetun periodin.   
	 * @param numero Periodi, joka haetaan. 1 >= numero <=5
	 * @return haettu periodi
	 */
	public Periodi annaPeriodi(int numero){
		return periodit[numero-1];
	}
	
	/**
	 * Asettaa periodin
	 * @param p Periodi, joka asetetaan
	 * @param numero Kuinka monennetta periodia ollaan asettamassa. 1 >= numero <=5
	 */
	public void asetaPeriodi(Periodi p, int numero){
		periodit[numero-1] = p;
	}
}
