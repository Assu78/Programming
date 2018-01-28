package demo2;

public class Jalkapallopelaaja extends Pelaaja {

	public enum Jalkaisuus{
		Oikea,
		Vasen
	}
	private double viikkopalkka;
	private Jalkaisuus jalkaisuus;
	
	public Jalkapallopelaaja(String nimi, int pelinumero, int pelipaikka, Jalkaisuus jalkaisuus) {
		this(nimi, pelinumero, pelipaikka, 0 , jalkaisuus);
	}

	public Jalkapallopelaaja(String nimi, int pelinumero, int pelipaikka,
			double viikkopalkka, Jalkaisuus jalkaisuus) {
		super(nimi, pelinumero, pelipaikka);
		this.viikkopalkka = viikkopalkka;
		this.jalkaisuus = jalkaisuus;
	}

	public double getViikkopalkka() {
		return viikkopalkka;
	}

	public void setViikkopalkka(double viikkopalkka) {
		this.viikkopalkka = viikkopalkka;
	}

	public Jalkaisuus getJalkaisuus() {
		return jalkaisuus;
	}

	@Override
	public String toString() {
		return "Jalkapallopelaaja [viikkopalkka=" + viikkopalkka
				+ ", jalkaisuus=" + jalkaisuus + ", nimi=" + nimi
				+ ", pelinumero=" + pelinumero + ", pelipaikka=" + pelipaikka
				+ "]";
	}	
}
