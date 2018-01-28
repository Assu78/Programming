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
			//Alla erikoiskohtelu ��kk�sille, jos oletamme, ett� k�yt�ss� on suomalainen aakkosto
			//Jos oletamme (teht�v�nannon mukaisesti) ASCII-aakkoston, switch-casen sijasta tarvitsemme vain default-haaran.
			switch(c){
			//ASCII taulukossa ��kk�set ovat hieman hajallaan.
			//HUOM! Break aina casen lopuksi, muulloin kaikki suoritetun casen j�lkeisetkin caset suoritetaan, eli kaikki ��kk�set muuttuisivat b:ksi. 
			case 'z':
				c = '�';
				break;
			case 'Z':
				c = '�';
				break;
			case '�':
				c = '�';
				break;
			case '�':
				c = '�';
				break;
			case '�':
				c = '�';
				break;
			case '�':
				c = '�';
				break;
			case '�':
				c = 'a';
				break;
			case '�':
				c = 'A';
				break;
			default:			
				//char-tyyppiset muuttujat ovat Javassa 'pellin alla' kokonaislukuja (ASCII-taulukosta)
				//joten kasvatetaan merkki� yhdell� (seuraava merkki), ja kerrotaan k��nt�j�lle,
				//ett� haluamme k�sitell� arvoa merkkin�.				
				c = (char)(c+1);
				break;
			}
			//Lis�t��n merkki salattuun merkkijonoon
			salattu += c;
		}
		
		System.out.println(salattu);
	}