package demo3;

public class Pelaaja {

	public enum Pelipaikka{
		Puolustaja,
		Hyokkaaja,
		Maalivahti
	}
	
	protected String nimi;
	protected int pelinumero;
	protected Pelipaikka pelipaikka;
	
	public Pelaaja(String nimi, int pelinumero, Pelipaikka pelipaikka) {
		this.nimi = nimi;
		this.pelinumero = pelinumero;
		this.pelipaikka = pelipaikka;
	}
	
	public String toString() {
		return "Pelaaja [nimi=" + nimi + ", pelinumero=" + pelinumero
				+ ", pelipaikka=" + pelipaikka + "]";
	}

	
}
