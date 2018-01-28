//Puukot ovat teroitettavia
public class Puukko extends Tyokalu implements Teroitettava{
	private boolean terava = false;
	
//Teroitettava-rajapinta
	@Override
	public void teroita() {
		terava = true;
	}

	@Override
	public boolean onkoTerava() {
		return terava;
	}

//Abstraktin Tyokalu-luokan metodien toteutus
	@Override
	public void kayta() {
		if(onkoTerava()){
			System.out.println("viuh");
		}else{
			System.out.println("Tylsää puukkoa ei voi käyttää.");
		}		
	}
}
