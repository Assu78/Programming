package demo3;

public class Kuutio implements Kappale{

	private double särmä;
	private Piste keskipiste;
	
	public Kuutio(double särmänPituus, Piste keskipiste){
		särmä = särmänPituus;
		this.keskipiste = keskipiste;
	}
	@Override
	public double annaAla() {
		return särmä*särmä*6;
	}

	@Override
	public Piste annaKeskipiste() {
		return keskipiste;
	}

}
