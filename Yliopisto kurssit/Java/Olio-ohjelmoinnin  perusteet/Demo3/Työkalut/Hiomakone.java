//Hiomakone on työkalu, jonka ominaisuuksiin kuuluu ladattavuus
public class Hiomakone extends Tyokalu implements Ladattava{

	private int akkuLataus = 0;

//abstraktin Tyokalu-luokan abstraktin metodin toteutus
	@Override
	public void kayta() {
		if(haeLataus() > PIENILATAUS){
			System.out.println("Surr");
		}else{
			System.out.println("Akussa ei ollut tarpeeksi virtaa hiontaan.");
		}
	}

//Ladattava-rajapinnan toteutus
	@Override
	public void lataa() {
		akkuLataus  = 100;
	}

	@Override
	public int haeLataus() {
		return akkuLataus;
	}
}
