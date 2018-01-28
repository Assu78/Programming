import java.util.Random;
import java.util.Arrays;

public class Positiiviset_alkiot{
	public static void main(String[] args){
		final Random rnd = new Random();
		double[] t = new double[rnd.nextInt(5) + 10];
		for (int i = 0; i<t.length ;i++ ) {
			t[i] = rnd.nextInt(20)-10.0;
			
		}
		System.out.println("Taulukko: " +  Arrays.toString(t));
		System.out.println("Positiivisia alkioita: " + positiivisia(t));

	}
	public static double positiivisia(double[] t){
		int maara = 0;
		for (int i = 0; i< t.length ;i++ ) {
			if(t[i] > 0){
				maara += 1;
			}
			
		}
		return maara;
	}
}