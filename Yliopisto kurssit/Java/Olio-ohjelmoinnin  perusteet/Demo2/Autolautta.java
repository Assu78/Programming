package demo2;

public class Autolautta extends Laiva {

	private final int kapasiteetti;
	private int matkustajat;
	private int ajoneuvot;
	
	private static int AUTOJENTILATARVE = 10;
	private static int MATKUSTAJIENTILATARVE = 1;
	
	public Autolautta(String nimi, double pituus, double syvays, double nopeus) {
		this(nimi, pituus, syvays, nopeus, 0,0,0);
	}
	
	public Autolautta(String nimi, double pituus, double syvays, double nopeus,
			int kapasiteetti){
		this(nimi,pituus,syvays,nopeus,kapasiteetti,0,0);
	}
			
	public Autolautta(String nimi, double pituus, double syvays, double nopeus,
			int kapasiteetti, int matkustajat, int ajoneuvot) {
		super(nimi, pituus, syvays, nopeus);
		this.kapasiteetti = kapasiteetti;
		this.matkustajat = matkustajat;
		this.ajoneuvot = ajoneuvot;
	}

	public int getMatkustajat() {
		return matkustajat;
	}

	public void setMatkustajat(int matkustajat) {
		if(getAutojenKaytettyKapasiteetti()+matkustajat > getKapasiteetti())
			return;
		
		this.matkustajat = matkustajat;
	}

	public int getAjoneuvot() {
		return ajoneuvot;
	}

	public void setAjoneuvot(int ajoneuvot) {
		if(getMatkustajienKaytettyKapasiteetti()+ajoneuvot*AUTOJENTILATARVE > getKapasiteetti())
			return;
		
		this.ajoneuvot = ajoneuvot;
	}

	public int getKapasiteetti() {
		return kapasiteetti;
	}

	private int getAutojenKaytettyKapasiteetti(){
		return getAjoneuvot()*AUTOJENTILATARVE;
	}
	
	private int getMatkustajienKaytettyKapasiteetti(){
		return getMatkustajat()*MATKUSTAJIENTILATARVE;
	}
	
	public int getKaytettyKapasiteetti(){
		return getAutojenKaytettyKapasiteetti()+getMatkustajienKaytettyKapasiteetti();
	}
	
	public int getVapaaTila(){
		return getKapasiteetti()-getKaytettyKapasiteetti();
	}
	
}
