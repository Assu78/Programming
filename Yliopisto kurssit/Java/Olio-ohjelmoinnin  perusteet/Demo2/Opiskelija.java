package demo2;

public class Opiskelija extends Yliopistolainen {

	private String opiskelijaTunnus;
	
	public Opiskelija(String nimi, String tunnus) {
		super(nimi);
		this.opiskelijaTunnus = tunnus;
	}

	public String gettunnus(){
		return opiskelijaTunnus;
	}
}
