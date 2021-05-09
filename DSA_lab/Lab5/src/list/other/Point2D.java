package list.other;
import java.util.Random;

public class Point2D {
	
	public static int POINT_HALF_SIZE = 2;
	private static Random random = new Random();
	
	private double x, y;
	
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point2D() {
		this(0, 0);
	}
	
	public Point2D(Point2D other) {
		this(other.x, other.y);
	}
	
	public Point2D clone() {
		return new Point2D(this);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return String.format("(%.2f, %.2f)", x, y);
	}
	
	public static Point2D[] generate(int n, int start, int end) {
		Point2D[] list = new Point2D[n];
		for(int i = 0; i<n; i++) {
			double x = random.nextDouble() * (end - start) + start;
			double y = random.nextDouble() * (end - start) + start;
			list[i] = new Point2D(x, y);
		}
		return list;
	}
	
	public static Point2D[] generate(int n) {
		return generate(n, -10, 10);
	}
	
	public static Point2D[] linear(int N, double a, double b, double xMin, double xMax){
		Point2D[] list = new Point2D[N];
		double step = (xMax - xMin)/(N-1); //xMax inclusive
		double x = xMin;
		for(int idx = 0; idx < N; idx++){
			x += step;
			double y = a * x + b; 
			list[idx] = new Point2D(x, y);
		}
		return list;
	} 
	
	public static double distanceAB(Point2D a, Point2D b) {
		double dx = a.x - b.x;
		double dy = a.y - b.y;
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	public double distanceTo(Point2D other) {
		return distanceAB(this, other);
	}
}
