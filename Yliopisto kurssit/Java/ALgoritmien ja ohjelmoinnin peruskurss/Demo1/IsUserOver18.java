import java.util.Scanner; 

/*
 * IsUserOver18-luokka kysyy käyttäjän
 * syntymävuotta ja laskee sen perusteella
 * onko käyttäjä alle vai yli 18 vuoden
 * 2014 lopussa.
 */ 
public class IsUserOver18 { 
 
    public static void main(String[] args){ 
       // Alustetaan muuttuja johon talletetaan käyttäjän ikä
       int age;
       // Luodaan uusi Scanner-olio 
       Scanner reader = new Scanner(System.in); 
       // Kysytään käyttäjältä syntymävuotta 
       System.out.println("Mikä on syntymävuotesi(vvvv)?"); 
       // Luetaan käyttäjän vastaus 
       int yearOfBirth = reader.nextInt(); 
       // Lasketaan ikä
       age = 2018 - yearOfBirth;
       
       // Onko käyttäjä alle 18-v
       if (age < 18) 
         System.out.println("User is under 18");
       
       // Onko käyttäjä yli 18-v
       else if (age > 18) 
         System.out.println("User is over 18");
       
       // Käyttäjä on 18-v
       else
         System.out.println("User is 18");
       
       // Suljetaan Scannerin yhteys syötevirtaan 
       reader.close(); 
    } 
} 
