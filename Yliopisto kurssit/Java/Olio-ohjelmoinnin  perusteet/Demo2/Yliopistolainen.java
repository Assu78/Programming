package demo2;

public abstract class Yliopistolainen {

	protected String nimi;
	
	public Yliopistolainen(String nimi) {
		this.nimi = nimi;
	}

	public String getNimi(){
		return nimi;
	}
}
