package demo2;

public class Opettaja extends Yliopistolainen {

	private double palkka;
	
	public Opettaja(String nimi, double palkka) {
		super(nimi);
		this.palkka = palkka;
	}

	public double getPalkka() {
		return palkka;
	}

	public void setPalkka(double palkka) {
		this.palkka = palkka;
	}	
}
