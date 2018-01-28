public class Demo2_1 {
	
	public static void main(String[] args){
		teht1();
	}
	private static void teht1() {
		int vanhempiFib = 0;
		int vanhaFib = 1;
		//Fibonacciluvut n= edellisten kahden summa
		
		Scanner s = new Scanner(System.in);
		System.out.println("Anna kokonaisluku");
		int arvo = s.nextInt();
		s.close();
		
		for(int i=1; i <= arvo; i++){
			int fib = vanhempiFib+vanhaFib;
			System.out.print(fib+ " "+ (i*i)+" ");
			
			//päivitetään fibonacciluvut
			vanhempiFib = vanhaFib;
			vanhaFib = fib;
		}
	}