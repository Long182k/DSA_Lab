package geom;
 
import java.awt.*;
 
public class Point2D extends GeomObject {
    public static int POINT_HALF_SIZE = 2;
    private double x;
    private double y;
 
    //    Constructors
    public Point2D() {
        this.x = 0;
        this.y = 0;
    }
 
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
 
    public Point2D(Point2D oldPoint) {
        this.x = oldPoint.getX();
        this.y = oldPoint.getY();
    }
 
    //    Getters & Setters
    public double getX() {
        return x;
    }
 
    public void setX(double x) {
        this.x = x;
    }
 
    public double getY() {
        return y;
    }
 
    public void setY(double y) {
        this.y = y;
    }
 
    //    Utilities
    public Point2D clone() {
        return new Point2D(this.x, this.y);
    }
 
    @Override
    public String toString() {
        return String.format("P(%6.2f, %6.2f)", this.x, this.y);
    }
 
    private static double getRandDouble(int lower, int upper) {
        return Math.random() * (upper - lower + 1) + lower;
    }
 
    public static Point2D[] generatePoint2D(int N) {
        Point2D[] tempArray = new Point2D[N];
        for (int i = 0; i < N; i++) {
            tempArray[i] = new Point2D(getRandDouble(-11, 10), getRandDouble(-11, 10));
        }
        return tempArray;
    }
 
    public static Point2D[] linear(int N, double xMin, double xMax, double a, double b) {
        Point2D[] list = new Point2D[N];
        double stepX = (xMax - xMin) / (N - 1); // xMax inclusive
        double x = xMin;
        for (int idx = 0; idx < N; idx++) {
            list[idx] = new Point2D(x, a * x + b);
            x += stepX;
        }
        return list;
    }
 
    public static double distanceAB(Point2D a, Point2D b) {
        return Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
    }
 
    public double distanceTo(Point2D point2D) {
        return Math.sqrt(Math.pow((this.getX() - point2D.getX()), 2) + Math.pow((this.getY() - point2D.getY()), 2));
    }
 
    @Override
    public void draw(Graphics g, SpaceMapping mapper) {
        Graphics2D g2d = (Graphics2D) g;
        Point2D point2D = mapper.logic2Device(this.getX(), this.getY());
 
        int x = (int) point2D.getX() - POINT_HALF_SIZE;
        int y = (int) point2D.getY() - POINT_HALF_SIZE;
 
        g2d.setColor(this.faceColor);
        g2d.fillOval(x, y, POINT_HALF_SIZE * 2 + 1, POINT_HALF_SIZE * 2 + 1);
    }
}