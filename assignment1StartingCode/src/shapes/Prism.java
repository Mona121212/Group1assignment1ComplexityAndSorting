package shapes;
/**
 * abstract base class for all prisms
 */

public abstract class Prism  extends Shape{
	
	protected double edgeLength;
	public Prism(double height, double edgeLength) {
		super(height);
		this.edgeLength = edgeLength;
	}
	
	/**
	 * volume for all prisms: base area * height
	 */
	
	@Override
	public double getVolume() {
		return getBaseArea()*height;
	}
	
	public double getEdgeLength() {
		return edgeLength;
	}

}
