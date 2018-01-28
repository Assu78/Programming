import java.util.Scanner;

public class Demo2 {
	
	public static void main(String[] args){
		teht3();
}
	private static void teht3() {
		Scanner s = new Scanner(System.in);
		System.out.println("Anna pariton kokonaisluku");
		int arvo = s.nextInt();
		s.close();
		
		if(arvo %2 == 0){
			System.out.println("Luku oli parillinen");
			return;
		}
		

		for(int rivi=1; rivi < arvo; rivi++){
			//Luettavampaa olisi, jos tehdään piirrä-metodi, jota kutsutaan kolme kertaa.
			//Metodit ovat seuraavan luennon aihe.
			for(int y=0; y<arvo-rivi;y++){
				System.out.print(" ");
			}
			for(int y=1; y<=rivi*2-1;y++){
				System.out.print("*");
			}
			for(int y=0; y<arvo-rivi;y++){
				System.out.print(" ");
			}
			
			System.out.println();
		}
			
		
		//Havainollistetaan ylemmän for-hässäkän tarkoitus:
		//System.out.println();
		
		for(int rivi=0; rivi < arvo*2-1; rivi++){
			System.out.print("*");
		}
		
		System.out.println();
		
		//Havainollistetaan alemman for-hässäkän tarkoitus:
		//System.out.println();
		
		for(int rivi=arvo-1; rivi > 0; rivi--){
			for(int y=0; y<arvo-rivi;y++){
				System.out.print(" ");
			}
			for(int y=1; y<=rivi*2-1;y++){
				System.out.print("*");
			}
			for(int y=0; y<arvo-rivi;y++){
				System.out.print(" ");
			}
			
			System.out.println();
		}
		
	}