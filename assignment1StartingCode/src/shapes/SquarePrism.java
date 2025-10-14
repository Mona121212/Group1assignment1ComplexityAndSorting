package shapes;

public class SquarePrism extends Prism
{
	public SquarePrism(double height, double edgeLength)  {
		super(height, edgeLength);
	}
	
	/**
	 * base area: s square
	 */
	
	@Override
	public double getBaseArea() {
		return edgeLength*edgeLength;
	}
	
}
