package geom;

import java.util.Comparator;

public class M2PointComparator implements Comparator<Point2D> {
	
	private Point2D M;
	
	public M2PointComparator(Point2D M) {
		this.M = M;
	}

	@Override
	public int compare(Point2D o1, Point2D o2) {
		double d1 = o1.distanceTo(M);
		double d2 = o2.distanceTo(M);
		if(Math.abs(d1 - d2) < 1e-7) 
			return 0; 
		if(d1 < d2) 
			return -1;
		return 1;
	}
	
}
