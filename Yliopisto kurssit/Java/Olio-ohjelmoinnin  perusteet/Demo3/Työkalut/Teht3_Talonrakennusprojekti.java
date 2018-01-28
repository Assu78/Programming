public class Teht3_Talonrakennusprojekti {
	
	public static void main(String[] args){
		Tyokalupakki pakki = new Tyokalupakki();
		
		pakki.lisaaTyokalu(new Vasara());
		pakki.lisaaTyokalu(new Hiomakone());
		pakki.lisaaTyokalu(new Kirves());
		pakki.lisaaTyokalu(new Puukko());
		pakki.lisaaTyokalu(new Sahkosaha());
		
		for(Tyokalu t : pakki.haeTyokalut()){
			t.kayta();
		}
		
		System.out.println("Ladataan ja teroitetaan\n");
		pakki.lataaLadattavat();
		pakki.teroitaTeroitettavat();
		
		for(Tyokalu t : pakki.haeTyokalut()){
			t.kayta();
		}
	}
}
