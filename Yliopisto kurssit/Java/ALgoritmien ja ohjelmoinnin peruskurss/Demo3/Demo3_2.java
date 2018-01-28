
import java.util.Random;
import java.util.Scanner;

public class Demo3_2 {
	
	public static void main(String[] args) {
		System.out.println(heitaNoppaa(2,5)); //teht2
	}
	private static int heitaNoppaa(int n, int tahkot) {
		//Virhetilanteiden hallinta
		if (tahkot <= 0 || n <= 0)
			return 0;
		
		Random arpoja = new Random();
		//Lasketaan maksimi n-1 nopan heitosta saaduille pisteille. Lopuksi +1, jotta satunnaislukuarvonta tapahtuu välillä [0,n]
		int maxPisteet = tahkot * (n - 1) + 1;
		
		//Arvotaan n-1 nopan heitosta saadut pisteet.
		//n-nopan heitosta tulee pisteiden summaksi tulee vähintään n, koska noppien pienin arvo on 1.
		//Koska arvonta tapahtuu välillä [0, (n-1) nopan pisteet], lisätään pienin mahdollinen arvo (=n) saatuun satunnaislukuun. 
		return arpoja.nextInt(maxPisteet) + n;
	}
	
	//ratkaisu toistorakenteella
	private static int heitaNoppaa2(int n, int tahkot) {
		//Virhetilanteiden hallinta
		if (tahkot <= 0 || n <= 0)
			return 0;
		
		int pisteet = 0;
		Random arpoja = new Random();
		
		for (int i = 0; i < n; i++) {
			// arpoja.nextInt(6) palauttaa satunnaisen arvon väliltä 0 ... 5
			pisteet += arpoja.nextInt(6) + 1;
		}
		return pisteet;
	}
	
}