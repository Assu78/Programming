
public class Demo1_3 {
	
	static int SATUNNAISMAX = 15;
	
	public static void main(String[] q){
		//Uusi random-olio		
		Random r = new Random();

		//arvotaan satunnaisluku
		int satunnaisluku = r.nextInt(SATUNNAISMAX);
		String s = "";
		//aletaan suorittaa algoritmia arvotun satunaisluvun verran
		for(int i=0; i<=satunnaisluku; i++){
			//katenoidaan numerot (0..pituus), yksi per iteraatio
			int pituus = r.nextInt(4);
			if(s.length() < pituus){
				s += i;
			}
			
			//heittää poikkeuksen, jos (i == 0 && pituus == 0)
			int kokonaisluku = Integer.parseInt(s);

			//koska i katenoidaan aina s:ään,
			//parillisilla i:llä s:n kokonaislukuarvo puolitetaan
			if(kokonaisluku%2 == 0){
				s = (kokonaisluku/2)+"";
			}
		}
		
		//algoritmi onnistuu, kun kokonaisluvussa on alkuperäisen satunnaisluvun verran numeroita.
		if(s.length() == satunnaisluku){
			System.out.println("Algoritmi onnistui.");
		}else{
			System.out.println("Algoritmi ei tällä kertaa onnistunut.");
		}
	}	
}