package demo3;

import java.util.ArrayList;

public class Joukkue {
	
	protected ArrayList<Pelaaja> pelaajat;
	protected String nimi;
	
	public Joukkue(String nimi){
		this.nimi = nimi;
		pelaajat = new ArrayList<>();
	}
	
	/**
	 * Lis‰‰ pelaajan joukkueeseen
	 * @param p Lis‰tt‰v‰ pelaaja
	 * @throws Pelaajanlis‰ysPoikkeus Heitet‰‰n, jos pelaajan lis‰ys ei onnistu.
	 */
	public void lisaaPelaaja(Pelaaja p) throws Pelaajanlis‰ysPoikkeus{
		pelaajat.add(p);
	}
	
	public boolean poistaPelaaja(Pelaaja p){
		return pelaajat.remove(p);
	}
	
	public String getNimi(){
		return nimi;
	}
	
	public String toString(){
		String joukkue = "Pelaajia joukkueessa "+getNimi()+":\n";
		for(int i=0; i<pelaajat.size(); i++){
			joukkue += pelaajat.get(i).toString()+"\n";
		}
		return joukkue;
	}
}
