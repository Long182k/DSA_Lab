package geom;

import java.util.Comparator;

public class PointComparator implements Comparator<Point2D>{

	@Override
	public int compare(Point2D o1, Point2D o2) {
		if(Math.abs(o1.getX() - o2.getX()) < 1e-7) 
			return 0; 
		if(o1.getX() < o2.getX()) 
			return -1;
		return 1;
	} 

}
