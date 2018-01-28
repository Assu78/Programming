package demo2;

import java.util.ArrayList;

public class Kurssi {

	private ArrayList<Yliopistolainen> kurssilaiset;
	private String nimi;
	private String tunnus;
	
	public Kurssi(String nimi, String tunnus) {
		kurssilaiset = new ArrayList<>();
		this.nimi = nimi;
		this.tunnus = tunnus;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getTunnus() {
		return tunnus;
	}

	public void LisaaHenkilo(Yliopistolainen henkilo){
		kurssilaiset.add(henkilo);
	}
	
	public void poistaHenkilo(Yliopistolainen henkilo){
		kurssilaiset.remove(henkilo);
	}
	
	public boolean onkoHenkiloKurssilla(Yliopistolainen henkilo){
		return kurssilaiset.contains(henkilo);
	}
}
