package shapes;

/**
 * represents a pentagonal prism
 */

public class PentagonalPrism extends Prism
{
	public PentagonalPrism(double height, double edgeLength) {
		super(height, edgeLength);
	}
	
	/**
	 * base area:
	 */
	@Override
	public double getBaseArea() {
		double tan54 = Math.tan(Math.toRadians(54));
		return (5*edgeLength*edgeLength*tan54) / 4.0;
	}

}
