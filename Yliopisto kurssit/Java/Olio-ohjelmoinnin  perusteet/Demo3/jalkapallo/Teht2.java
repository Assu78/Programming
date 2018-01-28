package demo3;

import demo3.Jalkapallopelaaja.Jalkaisuus;
import demo3.Pelaaja.Pelipaikka;

public class Teht2 {

	public static void main(String[] args) {
		Jalkapallojoukkue joukkue = new Jalkapallojoukkue("TPS", "Kupittaa");
		
		try {
			
			joukkue.lisaaPelaaja(new Jalkapallopelaaja("Maalivahti 1", 10 , Pelipaikka.Maalivahti, 2.5, Jalkaisuus.Vasen));
			joukkue.lisaaPelaaja(new Jalkapallopelaaja("Maalivahti 2", 10 , Pelipaikka.Maalivahti, 3.5, Jalkaisuus.Oikea));
			
			joukkue.lisaaPelaaja(new Jalkapallopelaaja("Jari", 10 , Pelipaikka.Hyokkaaja, 23.5, Jalkaisuus.Oikea));
			joukkue.lisaaPelaaja(new Jalkapallopelaaja("Sami", 12 , Pelipaikka.Hyokkaaja, 20.5, Jalkaisuus.Oikea));
			
			//joukkue.lisaaPelaaja(new Pelaaja("Virheellinen pelaaja", 2, Pelipaikka.Maalivahti));
									
			 //joukkue.lisaaPelaaja(new Jalkapallopelaaja("Ylim‰‰r‰inen Maalivahti", 10 , Pelipaikka.Maalivahti, 0.5, Jalkaisuus.Oikea));
			 
			/*
			 * for(int i=0; i< 40; i++){
			 *  joukkue.lisaaPelaaja(new Jalkapallopelaaja("Jari", 10 , Pelipaikka.Hyokkaaja, 23.5, Jalkaisuus.Oikea));
			 * }
			 */
			
		} catch (Pelaajanlis‰ysPoikkeus e) {
			System.out.println("Tapahtui virhe pelaajaa lis‰tess‰: ");
			System.out.println(e.getMessage());
			return;
		}
		
		joukkue.tulostaPelaajatViikkopalkanMukaan();
		System.out.println();
		joukkue.tulostaArvokkaimmatPelaajat(1);
	}

}
