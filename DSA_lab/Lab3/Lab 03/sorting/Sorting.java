package sorting;

import geom.M2PointComparator;
import geom.Point2D;
import geom.PointComparator;

public class Sorting {
	public static void main(String[] args) {
		SortDemo.demo(new StraightInsertionSort<>(false));
		SortDemo.demo(new StraightSelectionSort<>(false));
		SortDemo.demo(new BubbleSort<>(false));
		SortDemo.demo(new ShellSort<>(false));
		question2();
		question3();
		question6();
	}
	
	public static void question2() {
		ISort<Point2D> alg = new StraightInsertionSort<Point2D>();
		Point2D[] result = SortingEval.timeit(alg, 10, 100);
		
		System.out.println("Straight Insertion Sort: Time Measurement");
		System.out.println("-----------------------------------------");
		System.out.println("Size\tTime (msec)");
		
		for(int i = 0; i<result.length; i++) {
			Point2D p = result[i];
			System.out.println(String.format("%d\t%f", (int) p.getX(), p.getY()));
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void question3() {
		int[] num_segments = {1, 3, 7};
		ISort[] algorithms = {
			new StraightInsertionSort<Point2D>(),
			new ShellSort<Point2D>(num_segments),
			new StraightSelectionSort<Point2D>(),
			new BubbleSort<Point2D>()
		};
		
		for(int aIdx=0; aIdx < algorithms.length; aIdx++){
			Point2D[] points = Point2D.generate(100, -20, 20);
			algorithms[aIdx].sort(points, new PointComparator());
			SortingEval.timeit(algorithms[aIdx], 500, 50);
		}
	}
	
	public static void question6() {
		Point2D center = new Point2D(0, 0);
		Point2D[] points = Point2D.generate(20);
		for(Point2D p : points) {
			center.setX(center.getX() + p.getX());
			center.setY(center.getY() + p.getY());
		}
		center.setX(center.getX() / points.length);
		center.setY(center.getY() / points.length);
		@SuppressWarnings("unused")
		M2PointComparator comp = new M2PointComparator(center);
	}
}
