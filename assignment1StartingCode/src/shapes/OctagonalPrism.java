package shapes;

public class OctagonalPrism extends Prism
{
	public OctagonalPrism(double height, double edgeLength) {
		super(height, edgeLength);
	}
	
	/**
	 * base area:
	 */
	@Override
	public double getBaseArea() {
		return 2*(1 + Math.sqrt(2))*edgeLength*edgeLength;
	}
}
