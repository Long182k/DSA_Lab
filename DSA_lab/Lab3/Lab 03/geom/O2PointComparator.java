package geom;

import java.util.Comparator;

public class O2PointComparator implements Comparator<Point2D>{

	@Override
	public int compare(Point2D o1, Point2D o2) {
		double d1 = o1.distanceTo(new Point2D(0, 0));
		double d2 = o2.distanceTo(new Point2D(0, 0));
		if(Math.abs(d1 - d2) < 1e-7) 
			return 0; 
		if(d1 < d2) 
			return -1;
		return 1;
	} 

}