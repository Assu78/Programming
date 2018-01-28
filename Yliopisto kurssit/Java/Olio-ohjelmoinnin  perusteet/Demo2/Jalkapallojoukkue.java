package demo2;

public class Jalkapallojoukkue extends Joukkue {
	
	private static final int MAKSIMIKOKO = 22;
	private static final int MAXMAALIVAHTEJA = 2;
	
	private String kotiStadion;
	private int maalivahteja = 0;	
	
	public Jalkapallojoukkue(String nimi, String kotiStadion) {
		super(nimi);
		this.kotiStadion = kotiStadion;
	}

	@Override
	public void lisaaPelaaja(Pelaaja p) {
		if(pelaajat.size() >= MAKSIMIKOKO)
			return;
		
		if(p.pelipaikka == Pelaaja.MAALIVAHTI && maalivahteja >=MAXMAALIVAHTEJA)
			return;
		
		super.lisaaPelaaja(p);
	}

	public String getKotiStadion() {
		return kotiStadion;
	}

	@Override
	public String toString() {
		return super.toString()+" kotiStadion=" + kotiStadion;
	}

}
