package geom;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import dsa2020.SpaceMapping;

public class Point2D extends GeomObject{
	
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

	@Override
	public void draw(Graphics g, SpaceMapping mapper) {
		Graphics2D g2 = (Graphics2D) g;
		Point2D point = mapper.logic2Device(this.getX(), this.getY());
		int x = (int)point.getX() - POINT_HALF_SIZE;
		int y = (int)point.getY() - POINT_HALF_SIZE;
		
		g2.setColor(this.faceColor);
		// g2.fillRect(x, y, POINT_HALF_SIZE + 1, POINT_HALF_SIZE*2 + 1);
		g2.fillOval(x, y, POINT_HALF_SIZE*2, POINT_HALF_SIZE*2);
	}
}
