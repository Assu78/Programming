package demo3;

import java.util.Arrays;

import demo3.Pelaaja.Pelipaikka;

public class Jalkapallojoukkue extends Joukkue {
	
	private static final int MAKSIMIKOKO = 22;
	private static final int MAXMAALIVAHTEJA = 2;
	
	private String kotiStadion;
	
	public Jalkapallojoukkue(String nimi, String kotiStadion) {
		super(nimi);
		this.kotiStadion = kotiStadion;
	}

	@Override
	public void lisaaPelaaja(Pelaaja p) throws PelaajanlisäysPoikkeus{
		if(p instanceof Jalkapallopelaaja == false)
			throw new PelaajanlisäysPoikkeus("Jalkapallojoukkueeseen voi lisätä vain jalkapallopelaajia.");
		
		if(pelaajat.size() >= MAKSIMIKOKO)
			throw new PelaajanlisäysPoikkeus("Jalkapallojoukkueessa on jo maksimimäärä pelaajia.");
		
		if(p.pelipaikka == Pelipaikka.Maalivahti && laskeMaalivahdit() >=MAXMAALIVAHTEJA)
			throw new PelaajanlisäysPoikkeus("Jalkapallojoukkueessa on jo tarpeeksi maalivahteja.");
		
		super.lisaaPelaaja(p);
	}

	public String getKotiStadion() {
		return kotiStadion;
	}

	private int laskeMaalivahdit(){
		Jalkapallopelaaja[] pelaajat = jarjestaPelaajatViikkopalkanMukaan();
		
		int maalivahdit = 0;
		for(Jalkapallopelaaja p : pelaajat)
			if(p.pelipaikka == Pelipaikka.Maalivahti)
				maalivahdit ++;
		
		return maalivahdit;
	}
	
	/**
	 * Palauttaa pelaajat järjestettyinä uudessa taulukossa.
	 * @return Uusi taulukko, johon jalkapallojoukkueen pelaajat on järjestetty nousevaan järjestykseen.
	 */
	private Jalkapallopelaaja[] jarjestaPelaajatViikkopalkanMukaan(){
		Jalkapallopelaaja[] jalkapallopelaajat = new Jalkapallopelaaja[pelaajat.size()];
		pelaajat.toArray(jalkapallopelaajat);
		
		Arrays.sort(jalkapallopelaajat);
		
		return jalkapallopelaajat;
	}
	
	/**
	 * Tulostaa jalkapallojoukkueen pelaajat viikkopalkan mukaan nousevassa järjestyksessä.
	 */
	public void tulostaPelaajatViikkopalkanMukaan(){
		tulostaArvokkaimmatPelaajat(pelaajat.size());
	}
	
	/**
	 * Tulostaa jalkapallojoukkueen arvokkaimmat pelaajat viikkopalkan mukaan nousevassa järjestyksessä.
	 * @param pelaajia kuinka monta arvokkainta pelaajaa tulostetaan
	 * @throws IllegalArgumentException Jos yritetään tulostaa joko negatiivinen määrä pelaajia, tai enemmän pelaajia kuin joukkueessa on. 
	 */
	public void tulostaArvokkaimmatPelaajat(int pelaajia) throws IllegalArgumentException{
		
		if(pelaajia < 0 || pelaajia > pelaajat.size())
			throw new IllegalArgumentException("Yritetty tulostaa virheellinen määrä pelaajia: "+pelaajia);
		
		Jalkapallopelaaja[] jalkapallopelaajat = jarjestaPelaajatViikkopalkanMukaan();
		
		for(int i=pelaajat.size()-pelaajia; i<jalkapallopelaajat.length; i++){
			System.out.println(jalkapallopelaajat[i]);
		}
	}
	
	@Override
	public String toString() {
		return super.toString()+" kotiStadion=" + kotiStadion;
	}

}

class PelaajanlisäysPoikkeus extends Exception{

	public PelaajanlisäysPoikkeus(String message) {
		super(message);
	}	
}