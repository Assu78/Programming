package demo3;

public class Jalkapallopelaaja extends Pelaaja implements Comparable<Jalkapallopelaaja>{

	/**
	 * Ihmisen jalkaisuus on t�ysin lueteltavissa: enum t�ll�in paras vaihtoehto.
	 */
	public enum Jalkaisuus{
		Oikea,
		Vasen,
		Molempi
	}
	private double viikkopalkka;
	private Jalkaisuus jalkaisuus;
	
	public Jalkapallopelaaja(String nimi, int pelinumero, Pelipaikka pelipaikka, Jalkaisuus jalkaisuus) {
		this(nimi, pelinumero, pelipaikka, 0 , jalkaisuus);
	}

	public Jalkapallopelaaja(String nimi, int pelinumero, Pelipaikka pelipaikka,
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

	@Override
	public int compareTo(Jalkapallopelaaja p) {
		/*
		 * compareTo palauttaa:
		 *  negatiivisen luvun, jos t�m� olio < toinen olio
		 *  nolla, jos oliot yht�suuret
		 *  positiivisen luvun, jos t�m� olio > toinen olio
		 *  
		 *  lukujen suuruudella ei v�li�; vain merkki ratkaisee.
		 */
		return (int) (this.getViikkopalkka()-p.getViikkopalkka());
		
		/*
		 * Vaihtoehtoisesti:
		 * 
		 * if(viikkopalkka > p.viikkopalkka)
		 * 	return 1;
		 * if viikkopalkka == p.viikkopalkka)
		 *  return 0;
		 *  
		 *  return -1;
		 */
	}	
}
