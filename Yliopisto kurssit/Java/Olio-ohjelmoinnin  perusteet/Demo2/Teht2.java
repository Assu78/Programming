package demo2;

public class Teht2 {

	public static void main(String[] args) {
		Joukkue joukkue = new Jalkapallojoukkue("TPS", "Kupittaan nurmet");
		Pelaaja jarkko = new Jalkapallopelaaja("Jarkko",4,Pelaaja.PUOLUSTAJA,Jalkapallopelaaja.Jalkaisuus.Oikea);
		Pelaaja mikko = new Jalkapallopelaaja("Mikko",2,Pelaaja.HYOKKAAJA,Jalkapallopelaaja.Jalkaisuus.Vasen);
		
		//Lis‰t‰‰n muutama pelaaja
		joukkue.lisaaPelaaja(jarkko);
		joukkue.lisaaPelaaja(mikko);
		for(int i=0; i<4000; i++)
			joukkue.lisaaPelaaja(new Pelaaja("d",6,Pelaaja.HYOKKAAJA));
		System.out.println(joukkue);
		
		//ja poistetaan yksi
		joukkue.poistaPelaaja(mikko);
		System.out.println(joukkue);
	}

}
