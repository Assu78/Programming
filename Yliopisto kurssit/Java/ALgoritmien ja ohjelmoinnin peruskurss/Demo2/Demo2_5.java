import java.util.Scanner;

public class Demo2 {
	
	public static void main(String[] args){
		teht5();
	}
	
	private static void teht5() {
		Scanner s = new Scanner(System.in);
		System.out.println("Anna kolme merkkijonoa");
		String s1 = s.nextLine();
		String s2 = s.nextLine();
		String s3 = s.nextLine();
		s.close();
		
		String tulos = "";
		
		//------------Etsi Uniikit Merkit; String s1, String s2, String s3----------------
		//for-silmukka itseroi s1:n l‰pi merkki kerrallaan ja lis‰‰ uniikit merkit tulos-merkkijonoon		
		for(int i=0; i< s1.length(); i++){
			String merkki = s1.charAt(i)+"";
			//String-luokassa on m‰‰ritelty metodi contains(String s). 
			//Metodi palauttaa true, jos parametrina annettu merkkijono sis‰ltyy kutsuttavaan olioon.
			if(tulos.contains(merkki) || s2.contains(merkki) || s3.contains(merkki)){
				continue;
			}
			//Uniikki merkki lˆytyi, lis‰t‰‰n se siis tulokseen.
			tulos += merkki;
		}
		
		//------------Etsi Uniikit Merkit; String s1, String s2, String s3----------------
		for(int i=0; i< s2.length(); i++){
			String merkki = s2.charAt(i)+"";
			if(tulos.contains(merkki) || s1.contains(merkki) || s3.contains(merkki)){
				continue;
			}
			tulos += merkki;
		}
		
		//------------Etsi Uniikit Merkit; String s1, String s2, String s3----------------
		for(int i=0; i< s3.length(); i++){
			String merkki = s3.charAt(i)+"";
			if(tulos.contains(merkki) || s2.contains(merkki) || s1.contains(merkki)){
				continue;
			}
			tulos += merkki;
		}
		
		System.out.println(tulos);
	}
}