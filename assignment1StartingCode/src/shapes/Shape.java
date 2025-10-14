package shapes;

/**
 * @author Mona
 * @since 2025
 * @version 1.0
 */

/**
 * Abstract base class representing a 3D geometric shape.
 * Implements Comparable to compare shapes by height (natural ordering).
 */

public abstract class Shape implements Comparable<Shape> {
	
	public double height;
	
	
	/**
     * Constructor for Shape
     * @param The height of the shape
     */
    public Shape(double height) {
    	this.height = height;
    }
    
    /**
     * Gets the height of the shape
     * @return height value
     */
    
    public double getHeight() {
    	return height;
    }
    
    /**
     * abstract method of calculate base area
     * @return the base area of shape
     */
    public abstract double getBaseArea();
    
    /**
     * abstract method to calculate volume
     * @return the volume of the shape
     * 
     */
    public abstract double getVolume();
    
    /**
     * compares this shape to another by height (natural ordering)
     * return positive if this > other (for descending order)
     * @param other the  shape to compare to
     * @return positive if this is taller, negative if shorter , 0 if equal
     */
    @Override
    public int compareTo(Shape other) {
    	// for descending order: larger height should come first
    	if(this.height > other.height) {
    		return -1;
    	} else if (this.height < other.height) {
    		return 1;
    	}
    	return 0; 
    }
    
    @Override
    public String toString() {
    	return String.format("%s - Height: %.2f, Base Area: %.2f, Volume: %.2f", 
    			this.getClass().getSimpleName(), height, getBaseArea(), getVolume());
    }

}
