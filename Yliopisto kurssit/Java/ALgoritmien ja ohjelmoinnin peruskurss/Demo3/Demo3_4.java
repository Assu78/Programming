
import java.util.Random;
import java.util.Scanner;

public class Demo3_4 {
	
	public static void main(String[] args) {
		System.out.println(poistaErikoismerkit("%gres&7Gds#)(d4,")); //teht4
	}
	public static String poistaErikoismerkit(String mjono) {
		String tulos = "";
		String sallitutMerkit = "qwertyuiop�asdfghjkl��zxcvbnm1234567890QWERTYUIOP�ASDFGHJKL��ZXCVBNM";
		for (int i = 0; i < mjono.length(); i++) {
			String c = mjono.charAt(i) + "";
			if (sallitutMerkit.contains(c)) {
				tulos += c;
			} else {
				tulos += " ";
			}
		}
		return tulos;
	}
}