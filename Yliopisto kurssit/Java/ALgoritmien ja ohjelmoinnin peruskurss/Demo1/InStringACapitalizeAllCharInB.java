// Otetaan Scanner-luokka käyttöön 
import java.util.Scanner; 


public class InStringACapitalizeAllCharInB { 
 
    public static void main(String[] args){ 
      
       // tulos merkkijono, jossa B merkkijonon kirjaimet A:ssa on muutettu isoiksi kirjaimiksi
       String result;
       
       // Luodaan uusi Scanner-olio 
       Scanner reader = new Scanner(System.in);
       
       // Pyydetään käyttäjää antamaan merkkkijono A
       System.out.println("Give a string, which length is more than a character");
       
       // Luetaan käyttäjän antama merkkijono 
       String stringA = reader.nextLine();
       
       // Pyydetään käyttäjää antamaan merkkkijono B
       System.out.println("Give a second string, which length is more than a character"); 
       
       // Luetaan käyttäjän antama merkkijono  
       String stringB = reader.nextLine();
       
       // Korvataan merkkijonossa A olevat merkkijonon B kirjaimet isoilla kirjaimilla
       
       result = stringA.replace(stringB, stringB.toUpperCase());
       
       // Tulostetaan tulosmerkkijono
       System.out.println(result);
       
       // Suljetaan Scannerin yhteys syötevirtaan 
       reader.close(); 
    } 
} 