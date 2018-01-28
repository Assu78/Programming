
import java.util.Scanner;

public class Demo3_6 {
	
	public static void main(String[] args) {
		teht6();
	}
	private static String lueSyote(String syotekehotus) {
		Scanner s = new Scanner(System.in);
		System.out.println(syotekehotus);
		String syote = s.nextLine();
		return syote;
	}
	
	private static int laske(String syote, String string) {
		int tulos = 0;
		for (int i = 0; i < syote.length(); i++) {
			if (string.contains(syote.charAt(i) + "")) {
				tulos++;
			}
		}
		return tulos;
	}
	
}
