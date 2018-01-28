//Kirvekset (Kirveet?) ovat työkaluja, joita voidaan teroittaa
public class Kirves extends Tyokalu implements Teroitettava{

	private boolean terava = false;
	
//teroita-rajapinnan toteuttaminen
	@Override
	public void teroita() {
		terava = true;
	}

	@Override
	public boolean onkoTerava() {
		return terava;
	}
//Tyokalu-luokan abstraktin metodin toteutus
	@Override
	public void kayta() {
		if(onkoTerava()){
			System.out.println("Tsop");
		}else{
			System.out.println("Kop (Kirves oli liian tylsÃ¤)");
		}	
	}
	
}
