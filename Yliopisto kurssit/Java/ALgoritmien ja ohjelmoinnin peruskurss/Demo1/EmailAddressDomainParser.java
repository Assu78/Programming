import java.util.Scanner; 

/**
 * EmailAddressDomainParser-luokka pyytää käyttäjän sähköpostiosoitetta 
 * ja erottaa siitä domain-nimen sekä tulostaa tämän ruuudulle. 
 */
public class EmailAddressDomainParser{
  
  public static void main(String[] args){
    
    // Luodaan uusi Scanner-olio 
    Scanner reader = new Scanner(System.in);
    
    // Kysytään käyttäjän sähköpostiosoitetta 
    System.out.println("What is your email address?");
    
    // Luetaan käyttäjän vastaus 
    String emailAddress = reader.nextLine();
    
    // Haetaan sähköpostiosoitteen domain-nimen erottavan @-merkin indeksi
    int indexOfDomainDelimiter = emailAddress.indexOf('@');
    
    // Erotetaan sähöpostiosoitteesta domain-nimi
    String domainName = emailAddress.substring(indexOfDomainDelimiter+1);
    
    // Tulostetaan domain-nimi
    System.out.println("The domain of the e-mail address " + emailAddress + " is " + domainName);
    
    // Suljetaan Scannerin yhteys syötevirtaan 
    reader.close(); 
    } 
} 