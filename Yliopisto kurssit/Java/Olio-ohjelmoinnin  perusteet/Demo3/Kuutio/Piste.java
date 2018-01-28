package demo3;

public class Piste {

	private double x;
	private double y;
	private double z;
	
	
	public Piste(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}


	public double getX() {
		return x;
	}


	public double getY() {
		return y;
	}


	public double getZ() {
		return z;
	}


	@Override
	public String toString() {
		return "Piste [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	
}
