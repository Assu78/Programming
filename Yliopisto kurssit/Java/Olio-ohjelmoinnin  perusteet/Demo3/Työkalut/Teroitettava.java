public interface Teroitettava {
	
	/**
	 * Teroittaa tämän olion terän
	 */
	void teroita();
	
	/**
	 * Tarkistaa, onko tämän olion terä terävä
	 * @return true, jos terävä, false jos vaatii teroitusta
	 */
	boolean onkoTerava();
}
