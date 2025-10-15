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

