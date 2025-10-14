package shapes;

import java.util.Comparator;
/**
 * comparator to compare shapes by base area in descending order
 */

public class BaseAreaComparator implements Comparator<Shape> {
	
	@Override
	public int compare(Shape s1, Shape s2) {
		double area1 = s1.getBaseArea();
		double area2 = s2.getBaseArea();
		
		if(area1 > area2) {
			return -1;
		} else if (area1 < area2) {
			return 1;
		}
		return 0;
		
	}
}

class VolumeComparator implements Comparator<Shape> {
	@Override
	public int compare(Shape s1, Shape s2) {
		// For descending order: larger volume comes first
		double vol1 = s1.getVolume();
		double vol2 = s2.getVolume();
		
		if(vol1 > vol2) {
			return -1;
		}else if (vol1 < vol2) {
			return 1;
		}
		return 0;
	}
}	

