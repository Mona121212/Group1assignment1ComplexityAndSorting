package shapes;

/**
 * Represents a Cylinder shape
 */

public class Cylinder extends Shape
{
	private double radius;
	
	/**
	 * constructor for cylinder
	 * @param the height of the cyliner
	 * @param the radius of the circular base
	 */
	
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}
	
	/**
	 * calculates base area cylinder
	 */
	@Override
	public double getBaseArea() {
		return Math.PI*radius*radius;
	}
	
	/**
	 * calculates volume: PI r square
	 */
	
	@Override
	public double getVolume() {
		return Math.PI*radius*radius*height;
	}
	
	public double getRadius() {
		return radius;
	}
}
