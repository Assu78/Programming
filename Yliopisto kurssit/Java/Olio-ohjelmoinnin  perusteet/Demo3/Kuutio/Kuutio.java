package demo3;

public class Kuutio implements Kappale{

	private double s�rm�;
	private Piste keskipiste;
	
	public Kuutio(double s�rm�nPituus, Piste keskipiste){
		s�rm� = s�rm�nPituus;
		this.keskipiste = keskipiste;
	}
	@Override
	public double annaAla() {
		return s�rm�*s�rm�*6;
	}

	@Override
	public Piste annaKeskipiste() {
		return keskipiste;
	}

}
