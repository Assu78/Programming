import java.util.Random;
import java.util.Scanner;

public class Demo3_1 {
	
	public static void main(String[] args) {
		
				System.out.println(onkoPalindromi("abbha"));
	}
	public static boolean onkoPalindromi(String mjono) {
		//Tarkastetaan merkit pareittain alusta ja lopusta. 
		//pituus puolitetaan, koska merkkipareja ei tarvitse tarkistaa kahteen kertaan
		for (int i = 0; i < mjono.length() / 2; i++) {
			/**
			 * merkkiparit merkkijonolle "abghba": (a,a); ok, (b,b); ok, (g,h); palautetaan false. Ilman merkkijonon pituuden puolitusta, parit (b,b), (a,a)
			 
			 */
			if (mjono.charAt(i) != mjono.charAt(mjono.length() - i - 1)) {
				//merkit eivät olleet samat; joten kyseessä ei voi olla palindromi.
				return false;
			}
		}
		//kaikki merkkiparit olivat samoja; kyseessä on palindromi
		return true;
	}
}