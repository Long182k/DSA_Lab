package sorting;
import geom.Point2D;
import geom.PointComparator;

public class SortDemo {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void demo(ISort sortAlg) {
		int N = 30;
		Point2D[] points = Point2D.generate(N, -10, 20);
		
		// Print points
		System.out.println("DEMO FOR " + sortAlg.getClass().getName() + ":");
		System.out.println(new String(new char[80]).replace('\0', '='));
		System.out.println("Unsorted list points:");
		System.out.println(new String(new char[80]).replace('\0',  '-'));
		for(int i = 0; i<N; i++)
			System.out.println(String.format("%3d | %s", i, points[i]));
		
		// Straight Insertion Sort
		sortAlg = (ISort<Point2D>) sortAlg;
		sortAlg.sort(points, new PointComparator());
		
		// Print points again
		System.out.println("\nSorted list of points (sorted by x-coordinates, ascending)");
		System.out.println(new String(new char[80]).replace('\0', '-')); 
		for(int i = 0; i<N; i++)
			System.out.println(String.format("%3d | %s", i, points[i]));
	}
}