import java.util.Scanner;

public class Demo2 {
	
	public static void main(String[] args){
		teht4();
	}

	private static void teht4() {
		Scanner s = new Scanner(System.in);
		System.out.println("Anna merkkijono");
		String arvo = s.nextLine();
		s.close();
		
		String uusiArvo = "";
		
		//
		for(int i=0; i< arvo.length(); i++){
			String merkki = arvo.charAt(i)+"";
			if(uusiArvo.contains(merkki)){
				//Jos merkki on jo lisätty lopputulokseen, jatketaan uudella kierroksella
				continue;
			}else{
				for(int x=i; x<arvo.length(); x++){
					//aloitetaan i:stä ja lisätään kaikki merkin esiintymät loppumerkkijonosta lopputulokseen 
					if((arvo.charAt(x)+"").equals(merkki)){
						uusiArvo += merkki;
					}
				}
			}
		}
		System.out.println(uusiArvo);
	}
}