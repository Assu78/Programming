import java.util.Scanner;

public class Demo2 {
	
	public static void main(String[] args){

		teht2();
}
private static void teht2() {
		Scanner s = new Scanner(System.in);
		System.out.println("Anna merkkijono");
		String arvo = s.nextLine();
		s.close();
		
		String salattu = "";
		for(int i=0; i<arvo.length();i++){
			char c = arvo.charAt(i);
			//Alla erikoiskohtelu ääkkösille, jos oletamme, että käytössä on suomalainen aakkosto
			//Jos oletamme (tehtävänannon mukaisesti) ASCII-aakkoston, switch-casen sijasta tarvitsemme vain default-haaran.
			switch(c){
			//ASCII taulukossa ääkköset ovat hieman hajallaan.
			//HUOM! Break aina casen lopuksi, muulloin kaikki suoritetun casen jälkeisetkin caset suoritetaan, eli kaikki ääkköset muuttuisivat b:ksi. 
			case 'z':
				c = 'å';
				break;
			case 'Z':
				c = 'Å';
				break;
			case 'å':
				c = 'ä';
				break;
			case 'Å':
				c = 'ä';
				break;
			case 'ä':
				c = 'ö';
				break;
			case 'Ä':
				c = 'Ö';
				break;
			case 'ö':
				c = 'a';
				break;
			case 'Ö':
				c = 'A';
				break;
			default:			
				//char-tyyppiset muuttujat ovat Javassa 'pellin alla' kokonaislukuja (ASCII-taulukosta)
				//joten kasvatetaan merkkiä yhdellä (seuraava merkki), ja kerrotaan kääntäjälle,
				//että haluamme käsitellä arvoa merkkinä.				
				c = (char)(c+1);
				break;
			}
			//Lisätään merkki salattuun merkkijonoon
			salattu += c;
		}
		
		System.out.println(salattu);
	}