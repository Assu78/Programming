public interface Ladattava {
	
	/**
	 * Luokkavakio, jolla merkitään akun latauksen loppumisen rajaa. Jos haeLataus() < PIENILATAUS, akuu täytyy ladata
	 */
	final int PIENILATAUS = 10;
	
	/**
	 * Lataa tämän ladattavan asian akun.
	 */
	void lataa();
	
	/**
	 * Tarkistaa tämän ladattavan olion latauksen tilan prosentteina.
	 * @return lataus prosentteina. 0 <= lataus <= 100
	 */
	int haeLataus();
}
