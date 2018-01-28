/*
 *T�m� on luokka, jossa on main-metoodi 
 *alusta tulee menu, joka kysyy, mit� k�ytt�j� halua tehd� (katsoa elokuvien listaa, tehd� varaus, lopeta) 
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LipunVaraus{
	 
	public enum Paivat{
		Maanantai, Tiistai, Keskiviikko, Torstai, Perjantai, Lauantai, Sunnuntai
	}
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){ 
		ArrayList<Elokuva> elokuvat = new ArrayList<>();
		elokuvat = makeElokuva(); // luo elokuvalistan
		System.out.println("Tervetuloa meid�n varaus systeemiin!");
		/* Menu, joka kysyy, mit� k�ytt��j� halua tehd�
		 * se tulee takaisin kun osa on tehty*/
		
		while(true){
			//scan = new Scanner(System.in);	
			System.out.println("\nJos haluat katsoa elokuvalistaa, sy�t� 1");
	 		System.out.println("Jos haluat tehd� varaus, sy�t� 2");
	 		System.out.println("Jos haluat lopeta, sy�t� 3");
	 		try{
	 			int choice = scan.nextInt(); 
	 			if (choice <  0 || choice > 3){
	 				System.out.println("Sy�te pit�isi olla 1, 2 tai 3. Yrit� uudelleen");
	 						continue;
	 			}
	 			else if (choice == 1){
		 			int index = 1; // joten lista alkaa numero 1:st�
		 			for (int i = 0; i < elokuvat.size(); i++){
		 		 	   System.out.println(index + ": " + elokuvat.get(i).annaElokuvanAika() + " '" + elokuvat.get(i).annaElokuvanNimi() + "' ") ;
		 		 	   index ++; 	   
		 			 }
		 			System.out.println("");
		 			continue; 
		 		}else if (choice == 2){
		 			String paiva = " ";	
		 		 	paiva = paivaValitus(); //Valitaan p�iv�n, jolloin katsotaan elokuvaa
		 		 	Elokuva chosenElokuva = valitseElokuva(elokuvat); // valitse elokuvan elokuvalistasta
		 			
		 			Istumapaikka istumaPaikka = valitsePaikan(); // valitse istumapaikan
		 			Asiakas asiakas = uusiAsiakas(chosenElokuva);//luo uuden asiakkaan ja kirjoita sen tietoja tiedostoon
		 			Lippu lippu = new Lippu(asiakas, istumaPaikka, paiva);
		 		}else if(choice == 3){
		 			System.out.println("Ohjelma on lopetettu");
					System.exit(1);
					continue;
		 		}
		 	}catch(Exception e){
		 			System.out.println("Virhe. Yrit� uudelleen");
		 			continue;
	 		}
		}
	}
	 
	/*T�m� metoodi sy� asiakkaan tietoja ja luo uuden asiakkaan
	 * @param Elokuva movie eli kaikkien elokuvien lista
	 * 
	 * */
	 
	 public static Asiakas uusiAsiakas(Elokuva leffa){		
		 		String asiakkaanNumero = " "; 
		 		String asiakkaanPosti = " ";  
		 		String asiakkaanNimi = " ";
		 		System.out.println("\nNyt tarvitetaan tietoja. \nAnna sun Sukunimi ja Etunimi: ");
		 		String tyhja = scan.nextLine();
		 		asiakkaanNimi = scan.nextLine();
		 		System.out.println(asiakkaanNimi + ", kiitos. Nyt kitjoita sun puhelinnumerosi:");
		 		asiakkaanNumero = scan.nextLine();
		 	   	System.out.println("Kiitos! Ja my�s s�hk�postisi:");
		 	   	//s�hk�postiosoitteess� pit�� olla @
		 	   	asiakkaanPosti = null;  
		 	   	while (true){ 
		 		   asiakkaanPosti = scan.nextLine();
		 		   if (asiakkaanPosti.contains("@")){
		 			   break;
		 		   }else{
	     			   System.out.println("V��rin formatti. Kirjoita se taas (Yrit� k�ytt�� @)");
		 			   continue; 
		 		   }
		 	   }
		 		
		 	   System.out.print(asiakkaanNimi + ", ");
		 	   Asiakas asiakas = new Asiakas(asiakkaanNimi, asiakkaanNumero, asiakkaanPosti, leffa); //luo uusi asiakas
		 	   System.out.println("Kiitos varauksestasi!");
		 	   return asiakas;
		 	   
	 }
	 
	/*
	 * @returns ArrayList<Elokuva>  elokuvalistan
	 * metoodi avaa listan elokuvista ja tekee � arrayList.
	 * jos tiedosto ei l�ydy, silloin koko ohjelma sulkee
	 * */ 
	 
	 public static ArrayList<Elokuva> makeElokuva(){
		 ArrayList<Elokuva> elokuvat = new ArrayList<Elokuva>();    
			try{
				Scanner scanFile = new Scanner(new File("elokuvat.txt"));
				while(scanFile.hasNextLine()){
					String line = scanFile.nextLine();
					for (int i = 2; i < line.length(); i++){
						if (line.substring(i-2, i).equals("00")){
				    		String elokuvanNimi = line.substring(0, i);
				      		String elokuvanAika = line.substring(i+2, line.length()); 
				       		Elokuva leffa = new Elokuva(elokuvanAika, elokuvanNimi);
				       		elokuvat.add(leffa);
				       		break;
				       	}
					}       
				}  
			scanFile.close();
			}catch (Exception e){
			  System.out.println("Tiedosto ei l�ydy");
			  System.exit(1);
			}  
			return elokuvat;
		}  

	 /*@returns String paivaValitus, p�iv�,kun asiakas haluaa katsoa elokuvaa */
	 
	 public static String paivaValitus(){ 
		System.out.println("Hei! Milloin haluat katsoa elokuvaa? \n \nValitse p�iv� sy�t�m�ll� sen nimi tai index. Sy�t� 0, jos haluat lopettaa");
		Paivat viikonpaiva = null; 
		while(true){
		//	scan = new Scanner(System.in);	
			int i = 1;
			for (Paivat paiva: Paivat.values()){
				System.out.print(i + " ");
				System.out.println(paiva);
				i++;	
			 }
			try{
			int s = scan.nextInt();  
				 if(s == 1){
			 		viikonpaiva = Paivat.Maanantai;
				}if(s == 2){
		 			viikonpaiva = Paivat.Tiistai;
				}if(s == 3){
					viikonpaiva = Paivat.Keskiviikko;
				}if(s == 4){
					 viikonpaiva = Paivat.Torstai; 
				}if(s == 5){
					 viikonpaiva = Paivat.Perjantai;
				}if(s == 6){
					viikonpaiva = Paivat.Lauantai;
				}if(s == 7){
					 viikonpaiva = Paivat.Sunnuntai; 
				}if(s == 0){
					 System.out.println("Ohjelma on lopetettu");
					 System.exit(1);
				}
			  }catch (Exception e){
						System.out.println("Virhe. Yrit� uudelleen: ");
						continue; 
						
				}
				System.out.println("Olen valinnut p�iv�: " + viikonpaiva + ". Nyt valitse elokuva: \n");
				return String.valueOf(viikonpaiva);	
		  } 
	}
    		 	
	 
	 /* @param ArrayList<Elokuva>elokuvat eli elokuvalista
	  * @returns Elokuva chosenMovie joka asiakais valitse 
	  * */
	
	 public static Elokuva valitseElokuva(ArrayList<Elokuva>elokuvat){ 
		 Elokuva chosenMovie = null;
		 while(true){
	//		 scan = new Scanner(System.in);
			 for (int i = 0; i < elokuvat.size(); i++){
				 System.out.println(i+1 + ": " + elokuvat.get(i).annaElokuvanAika() + " '" + elokuvat.get(i).annaElokuvanNimi() + "' ") ;
		 	  }
			 System.out.println("\nValitse elokuva sy�m�ll� sen indeksin. Sy� 0 jos haluat lopettaa");
			 //elukuvan valitseminen
			 try{
				 int movieNumber = scan.nextInt(); 
				 if(movieNumber == 0){
					 System.out.println("Ohjelma on lopetettu");
					 System.exit(1);
					}
				 if (movieNumber > 0){
					 movieNumber-=1; 
				 }
				 chosenMovie = elokuvat.get(movieNumber); 		
				 System.out.println("Sin� olen valinnut elokuvan: '" + elokuvat.get(movieNumber).annaElokuvanNimi() + "' at " + elokuvat.get(movieNumber).annaElokuvanAika()); 
			 	}catch (Exception e){
		 	     System.out.println("Virhe! Yrit� uudelleen\n");
		 	     continue;
			 	}	 
			 return chosenMovie;
		 } 
	}
	 
	 /*
	  * @returns ArrayList<Integer>istumaPaikka valittu paikka 
	  * paikassa on valittu riivi ja paikka
	  * */
	 public static Istumapaikka valitsePaikan(){ 		 	  		 	   
		int riivi = 0; 
		int paikka = 0; 
		while(true){	
			System.out.println("Nyt voit valita riivi: 1-12");
			riivi = scan.nextInt();
				if (riivi < 0 || riivi > 12){ 
					System.out.println("T�m� on v��rin numero. Valitse uudelleen");
				 	continue;
				 }else{
				 	System.out.println("Ja paikan: 1 - 32");  
				 	paikka = scan.nextInt();
				 	if (paikka < 0 || paikka > 33){ 
				 		System.out.println("T�m� on v��rin numero. Valitse uudelleen");
				 		continue;
				 		}else{
				 			System.out.println("Sinun paikkasi on: "  + "riivi " + riivi + ", paikka " + paikka); 
				 			break; 	
				 		}
				 } 
			} 
		 Istumapaikka istumaPaikka = new Istumapaikka(riivi, paikka);
		return istumaPaikka;
	 }
}

