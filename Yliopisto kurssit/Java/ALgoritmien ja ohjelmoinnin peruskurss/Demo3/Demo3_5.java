
import java.util.Random;
import java.util.Scanner;

public class Demo3_5 {
	
	public static void main(String[] args) {
		teht5();
	}
	private static void teht5() {
		Scanner s = new Scanner(System.in);
		String mjono = s.nextLine();
		s.close();
		
		System.out.println(mjono.length());
		print(mjono.length());
		
		//k�yd��n mjono l�pi merkki kerrallaan, 
		//lasketaan kuinka monta kyseist� merkki� mjonosta l�ytyy
		//ja tulostetaan tarpeeksi asteriskeja.
		for (int i = 0; i < mjono.length(); i++) {
			int maara = laskeMerkit(mjono, mjono.charAt(i), 1);
			print(maara);
		}
		
		print(mjono.length());
	}
	
	/**
	 * Laskee mjono-parametrist� merkki-muuttujien m��r�n. Lopuksi palauttaa m��r�n jaettuna parametrin� annetulla jakajalla
	 * 
	 * @param mjono
	 *            Merkkijono, josta merkkej� lasketaan
	 * @param merkki
	 *            merkki, jota etsit��n
	 * @param jakaja,
	 *            luku, jolla merkkien l�ydetty m��r� jaetaan. Jos 0, nostetaan ArithmeticException
	 * @return l�ydettyjen merkkien m��r� jaettuna jakajalla.
	 */
	private static int laskeMerkit(String mjono, char merkki, int jakaja) {
		int maara = 0;
		for (int j = 0; j < mjono.length(); j++) {
			if (mjono.charAt(j) == merkki) {
				maara++;
			}
		}
		return maara / jakaja;
	}
	
	/**
	 * Tulostaa asteriskeja. Lopuksi rivinvaihto.
	 * 
	 * @param merkkiMaara
	 *            kuinka monta asteriskia tulostetaan
	 */
	private static void print(int merkkiMaara) {
		for (int i = 0; i < merkkiMaara; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}