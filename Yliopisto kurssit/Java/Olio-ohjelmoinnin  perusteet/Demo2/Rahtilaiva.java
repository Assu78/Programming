package demo2;

public class Rahtilaiva extends Laiva{

	private double kapasiteetti;
	private double rahti;
	
	public Rahtilaiva(String nimi, double pituus, double syvays, double nopeus) {
		this(nimi, pituus, syvays, nopeus, 10, 0);
	}
	
	public Rahtilaiva(String nimi, double pituus, double syvays, double nopeus, double kapasiteetti, double rahti) {
		super(nimi, pituus, syvays, nopeus);
		
		if(rahti > kapasiteetti)
			rahti = kapasiteetti;
		
		this.kapasiteetti = kapasiteetti;
		this.rahti = rahti;
	}

	@Override
	public double getNopeus() {
		double nopeusKerroin = rahti/kapasiteetti;
		return super.getNopeus()*nopeusKerroin;
	}

	public double getKapasiteetti() {
		return kapasiteetti;
	}

	public void setKapasiteetti(double kapasiteetti) {
		this.kapasiteetti = kapasiteetti;
	}

	public double getRahti() {
		return rahti;
	}

	/**
	 * Asettaa uuden rahtimäärän
	 * @param rahti rahti, joka laivaan lastataan
	 * @return rahdista ylijäänyt määrä
	 */
	public double setRahti(double rahti) {
		double ylijaama = 0;
		if(rahti > kapasiteetti){
			ylijaama = rahti-kapasiteetti;
			rahti = kapasiteetti;			
		}
		
		this.rahti = rahti;
		
		return ylijaama;
	}
	
	
	
}
