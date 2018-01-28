package demo3;

public class Teht1 {

	public static void main(String[] args) {
		Piste piste = new Piste (1,2,3);
		
		Kuutio kuutio = new Kuutio(7, piste);
		
		System.out.println(kuutio.annaAla());
		System.out.println(kuutio.annaKeskipiste());
	}

}
