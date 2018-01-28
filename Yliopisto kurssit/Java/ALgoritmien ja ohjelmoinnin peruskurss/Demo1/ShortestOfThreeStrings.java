public class ShortestOfThreeStrings {
  
  public static void main(String[] args) {
    
    String shortestString = "";
    
    
    
    // Onko syötteitä vähemmän kuin 3?
    if (args.length < 3 ) 
      shortestString = "Problem: expected three strings to compare";
    
    // Onko 1. merkkijono yhtä pitkä kuin 2.?  
    else if ( args[0].length() == args[1].length() ) 
      shortestString  = "Problem: two or more strings are of equal length";
   
    // Onko 1. merkkijono yhtä pitkä kuin 3.?
    else if ( args[0].length() == args[1].length() )
      shortestString  = "Problem: two or more strings are of equal length";
    
    // Onko 2. merkkijono yhtä pitkä kuin 3.?
    else if ( args[0].length() == args[1].length() )
      shortestString  = "Problem: two or more strings are of equal length";
    
    /* Kolmesta syötetystä merkkijonosta lyhyimmän tulostaminen */
    
    // Onko 1. merkkijono lyhyempi kuin 2. merkkijono?
    else if (args[0].length() < args[1].length()) {
              
        if (args[0].length() < args[2].length())
          // 1. merkkijono < 2. merkkijono < 3. merkkijono
          shortestString  = args[0];
        
        else 
          // 3. merkkijono < 1. merkkijono < 2. merkkijono
          shortestString  = args[2];
    }
    
    // 2. merkkijono on lyhyempi kuin 1. merkkijono
    else  {
        
        if (args[1].length() < args[2].length())
          // 2. merkkijono < 1. merkkijono < 3. merkkijono
          shortestString  = args[1];
        
        else 
          // 3. merkkijono < 2. merkkijono < 1. merkkijono
          shortestString  = args[2];
    }
        
    // Tulostetaan lyhyin merkkijono tai virheilmoitus
    System.out.println(shortestString);     
  }
}