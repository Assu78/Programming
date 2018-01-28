package demo2;

public class Teht1 {

	public static void main(String[] args){
		Laiva l = new Laiva("d",5,5,5);
		Laiva l1 = new Laiva("d",5,5,4);
		
		System.out.println(l.matkaanKuluvaAika(5));
		System.out.println(l1.matkaanKuluvaAika(5));
	}
}
