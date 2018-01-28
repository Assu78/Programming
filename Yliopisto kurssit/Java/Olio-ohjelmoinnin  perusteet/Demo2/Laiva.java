package demo2;

public class Laiva {

	private static double SOLMUTKILOMETREINATUNNISSA = 1.852;
	
	private String nimi;
	private double pituus;
	private double syvays; 
	private double nopeus;
	
	/**
	 * Laivan konstruktori.
	 * @param nimi Laivan nimi
	 * @param pituus Laivan pituus metreinä
	 * @param syvays Laivan syväys metreinä
	 * @param nopeus Laivan nopeus solmuina tunnissa
	 */
	public Laiva(String nimi, double pituus, double syvays, double nopeus) {
		this.nimi = nimi;
		this.pituus = pituus;
		this.syvays = syvays;
		this.nopeus = nopeus;
	}
	
	/**
	 * Laskee matkaan kuluvan ajan.
	 * 
	 * @param matka Kuljettava matka kilometreinä.
	 * @return matkaan kuluva aika tunteina. Ääretön, 
	 * 			jos laiva seisoo tai matka on negatiivinen.
	 */
	public double matkaanKuluvaAika(double matka){
		if(nopeus == 0.0 || matka < 0)
			return Double.POSITIVE_INFINITY;
		
		return matka/(Math.abs(nopeus)/SOLMUTKILOMETREINATUNNISSA);
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	//Huom, laivan pituuden muutosmetodi puuttuu. 
	//Laivan pituus harvoin muuttuu.
	
	public double getPituus() {
		return pituus;
	}

	public double getSyvays() {
		return syvays;
	}

	public void setSyvays(double syvays) {
		this.syvays = syvays;
	}

	public double getNopeus() {
		return nopeus;
	}

	public void setNopeus(double nopeus) {
		this.nopeus = nopeus;
	}
	
}
