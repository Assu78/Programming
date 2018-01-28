public class LinkedList<T> {
	
	public static void main(String[] main){
		LinkedList<Integer> lista = new LinkedList<>(); //tyhjä lista
		lista.tulostaLista();
		
		lista.lisaaSolmu(new Solmu<Integer>(3));
		lista.lisaaSolmu(new Solmu<Integer>(1));
		lista.lisaaSolmu(new Solmu<Integer>(6));
		
		System.out.println("Tulostetaan lista:");
		lista.tulostaLista();
		
		System.out.println("Haetaan alkioita:");
		//tulostaa muistiosoitteen, josta solmu-olio löytyy; jos halutaan tulostaa solmun oikea arvo, täytyy Solmu-luokkaan toteuttaa toString-metodi
		System.out.println(lista.hae(3));
		System.out.println(lista.hae(7));
		System.out.println(lista.hae(6));
		
		System.out.println("\nPoistetaan kaikki paitsi solmu, jonka arvo on 1");
		
		lista.poista(3);
		lista.poista(6);
		
		System.out.println(lista.hae(3));
		System.out.println(lista.hae(6));
		
		System.out.println("\nKoko lista:");
		lista.tulostaLista();
	}
	
	Solmu<T> alku = null;
	
	public void lisaaSolmu(Solmu<T> s){
		//eka alkio
		if(alku == null){
			alku = s;
			return;
		}
		
		Solmu<T> nykyinen = alku;
		//vain listan viimeinen solmu.annaSeuraava palauttaa null
		while(nykyinen.annaSeuraava() != null){
			nykyinen = nykyinen.annaSeuraava();
		}
		nykyinen.asetaSeuraava(s);
		s.asetaEdellinen(nykyinen);
	}
	
	public void poista(int i){
		
		//lista tyhjä tai viimeinen alkio
		if(alku == null || alku.annaSeuraava() == null){
			alku = null;
			return;
		}
		
		if(alku.annaArvo() == i){
			alku = alku.annaSeuraava();
			return;
		}
		
		Solmu<T> nykyinen = alku;
		while(nykyinen.annaSeuraava() != null){			
			Solmu<T> seuraava = nykyinen.annaSeuraava();
			if(seuraava.onkoArvo(i)){
				//asetetaan nykyisen seuraavaksi seuraavan seuraava
				//hypätään siis yhden yli
				Solmu<T> uusiSeuraava = seuraava.annaSeuraava();
				nykyinen.asetaSeuraava(uusiSeuraava);
				if(uusiSeuraava != null){
					uusiSeuraava.asetaEdellinen(nykyinen);
				}
			}else{
				nykyinen = seuraava;
			}
		}
	}
	
	public Solmu<T> hae(int i){
		if(alku == null)
			return null;
		
		Solmu<T> nykyinen = alku;
		
		while(nykyinen != null && !nykyinen.onkoArvo(i)){
			nykyinen = nykyinen.annaSeuraava();
		}
		
		return nykyinen;
	}
	
	public void tulostaLista(){
		Solmu<T> nykyinen = alku;
		
		if(nykyinen == null){
			System.out.println("Lista on tyhjä.");
			return;
		}
		
		System.out.println(nykyinen.annaArvo() + "("+nykyinen.annaEdellinen()+"/"+nykyinen.annaSeuraava()+")");
		
		//vain listan viimeinen solmu.annaSeuraava palauttaa null
		while(nykyinen.annaSeuraava() != null){
			nykyinen = nykyinen.annaSeuraava();
			//Varmistutaan kaksisuuntaisuudesta: tulostetaan alkion arvo sekä sulkeissa (edellisen alkion arvo / seuraavan alkion arvo)
			System.out.println(nykyinen.annaArvo()+ "("+nykyinen.annaEdellinen()+"/"+nykyinen.annaSeuraava()+")");
		}
	}
}

class Solmu<T>{
	//listan seuraava solmu; null, jos solmuinstanssi on listan viimeinen
	private Solmu<T> seuraava = null;
	private Solmu<T> edellinen = null;
	private final T arvo;
	
	public Solmu(T arvo){
		this.arvo = arvo;
	}
	
	public T annaArvo(){
		return arvo;
	}
	
	public boolean onkoArvo(T arvo){
		// == ei kelpaa, koska T on viittaustyyppinen
		return this.arvo.equals(arvo);
	}
	
	public void asetaSeuraava(Solmu<T> s){
		seuraava = s;
	}
	
	public Solmu<T> annaSeuraava(){
		return seuraava;
	}
	
	public void asetaEdellinen(Solmu<T> s){
		edellinen = s;
	}
	
	public Solmu<T> annaEdellinen(){
		return edellinen;
	}

	public String toString(){
		return arvo+"";
	}
}