package shapes;

/**
 * represents a pyramid shape
 */

public class Pyramid extends Shape{
		private double edgeLength;
		public Pyramid(double height, double edgeLength) {
			super(height);
			this.edgeLength = edgeLength;
		}
		
		/**
		 * Base area: s²
		 */
		
		@Override
		public double getBaseArea() {
			return edgeLength *edgeLength;
		}
		
		/**
		 * volume: (1/3)s²h
		 */
		
		@Override
		public double getVolume() {
			return (1.0/3.0)*edgeLength*edgeLength*height;
		}
		
		public double getEdgeLength() {
			return edgeLength;
		}
		
	}


