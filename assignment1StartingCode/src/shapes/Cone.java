package shapes;

public class Cone extends Shape
{
	private double radius;
	public Cone(double height, double radius) {
		super(height);
		this.radius = radius;
	}
	
	/**
	 * base area: πr²
	 */
	
	@Override
	public double getBaseArea() {
		return Math.PI*radius*radius;
	}
	
	/**
	 * volume:(1/3)πr²h
	 */
	
	@Override
	public double getVolume() {
		return (1.0/3.0)*Math.PI*radius*radius*height;
	}
	
	public double getRadius() {
		return radius;
	}

}

/**
 * represents a pyramid with square base
 */


