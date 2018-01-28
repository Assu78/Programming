import java.util.ArrayList;

public class Tyokalupakki {
	
	private ArrayList<Tyokalu> tyokalut = new ArrayList<>();
	
	public void lisaaTyokalu(Tyokalu t){
		tyokalut.add(t);
	}
	
	public ArrayList<Tyokalu> haeTyokalut(){
		return tyokalut;
	}
	
	public void teroitaTeroitettavat(){
		for(Tyokalu t: tyokalut){
			//Onko tällä tyokalulla terä?
			if(t instanceof Teroitettava){
				//Hankitaan viittaus tyokalun terään (rajapinta)
				Teroitettava tera = ((Teroitettava) t);
				if(!tera.onkoTerava()){
					//Jos terä on tylsä, teroitetaan, muulloin ei tarvitse.
					tera.teroita();
				}
			}
		}
	}
	
	public void lataaLadattavat(){
		for(Tyokalu t: tyokalut){
			//Onko tällä tyokalulla akku?
			if(t instanceof Ladattava){
				//Vastaavasti kuin teroittamismetodissa, käsitellään tätä työkalua vain ladattavana
				Ladattava akku = ((Ladattava) t);
				if(akku.haeLataus() < 10){
					//Jos akku on loppumassa (<10%), ladataan se
					akku.lataa();
				}
			}
		}
	}
}
