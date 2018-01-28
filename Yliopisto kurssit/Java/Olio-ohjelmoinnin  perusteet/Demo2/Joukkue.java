package demo2;

import java.util.ArrayList;

public class Joukkue {
	
	protected ArrayList<Pelaaja> pelaajat;
	protected String nimi;
	
	public Joukkue(String nimi){
		this.nimi = nimi;
		pelaajat = new ArrayList<>();
	}
	
	public void lisaaPelaaja(Pelaaja p){
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
