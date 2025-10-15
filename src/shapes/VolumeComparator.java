package shapes;
import java.util.Comparator;

/** Comparator to compare shapes by volume in descending order */
public class VolumeComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        double v1 = s1.getVolume(), v2 = s2.getVolume();
        return (v1 > v2) ? -1 : (v1 < v2) ? 1 : 0; // descending
    }
}
