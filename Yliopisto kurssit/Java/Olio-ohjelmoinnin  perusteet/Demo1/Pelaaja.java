public class Pelaaja {

	public static final int PUOLUSTAJA = 0;
	public static final int HYOKKAAJA = 1;
	public static final int MAALIVAHTI = 2;
	
	private String nimi;
	private int pelinumero;
	private int pelipaikka;
	
	public Pelaaja(String nimi, int pelinumero, int pelipaikka) {
		this.nimi = nimi;
		this.pelinumero = pelinumero;
		this.pelipaikka = pelipaikka;
	}
	
	public String toString() {
		return "Pelaaja [nimi=" + nimi + ", pelinumero=" + pelinumero
				+ ", pelipaikka=" + pelipaikka + "]";
	}

	
}
