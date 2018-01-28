//S‰hkˆsaha on sek‰ ladattava ett‰ teroitettava
public class Sahkosaha extends Tyokalu implements Ladattava, Teroitettava{

	boolean terava = false;
	double lataus = 0;
	
//Teroitettava-rajapinta
	@Override
	public void teroita() {
		terava = true;	
	}

	@Override
	public boolean onkoTerava() {
		return terava;
	}

//Ladattava-rajapinta
	@Override
	public void lataa() {
		lataus = 1;
	}

	@Override
	public int haeLataus() {
		return (int)(lataus*100);
	}

//Tyokalu-luokan abstraktin metodin toteutus
	@Override
	public void kayta() {
		if(haeLataus() > PIENILATAUS){
			if(onkoTerava()){
				System.out.println("Triip");
			}else{
				System.out.println("Skr√§√§p (Saha vaatii teroitusta)");
			}
		}else{
			System.out.println("... Akussa ei ollut tarpeeksi virtaa sahan k√§ytt√§miseen.");
		}
	}
	
}
