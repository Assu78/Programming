 /**
 * QuadraticEquation-luokka laskee
 * toisen asteen yhtälön juuret.
 */
public class QuadraticEquation {
  
  public static void main(String[] args) { 
   
    // yhtälön juuret
    double x1 = 0.0, x2 = 0.0;
    
    // kertoimet
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int c = Integer.parseInt(args[2]);
    
    // laskee toisen asteen yhtälön diskriminantin D
    int D = (int)Math.pow(b, 2) - (4 * a * c);
    
    // D > 0, kaksi juurta
    if ( D > 0 ) {
      // laskee ensimmäisen juuren
      x1 = (-b - Math.sqrt(D)) / (2 * a);
      
      // laskee toisen juuren
      x2 = (-b + Math.sqrt(D)) / (2 * a);
      
      //tulostaa juuret
      System.out.println("Toisen asteen yhtälöllä on kaksi juurta: x1= " + x1 + " ja x2= " + x2);
    }
    
    // tai D = 0, yksi juuri
    else if ( D == 0 ) {
      
      // laskee ensimmäisen juuren
      x1 = -(b / (2 * a));
      
      // tulostaa juuren
      System.out.println("Toisen asteen yhtälöllä on yksi juuri: x1= " + x1);
    }
    
    // yhtälön diskriminantti D < 0, yhtälöllä ei ole reaalijuuria
    else
 
      System.out.println("yhtälöllä ei ole reaalijuuria");
  }
  
}