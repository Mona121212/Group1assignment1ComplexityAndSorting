package shapes;

public class TriangularPrism extends Prism
{
	public TriangularPrism(double height, double edgeLength) {
		super(height, edgeLength);
	}

	/**
	 * base area: 
	 */
	
	@Override
	public double getBaseArea() {
		return(edgeLength*edgeLength*Math.sqrt(3))/4.0;
	}
}
