package geom;

import java.util.List;
import java.util.ListIterator;

public class Point2D {
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

    private static double getRandDouble(double lower, double upper) {
        return Math.random() * (upper - lower) + lower;
    }

    public static Point2D[] generatePoint2D(int N) {
        return generatePoint2D(N, -10, 10);
    }
    public static Point2D[] generatePoint2D(int N, double lower, double upper) {
        Point2D[] tempArray = new Point2D[N];
        for (int i = 0; i < N; i++) {
            tempArray[i] = new Point2D(getRandDouble(lower, upper), getRandDouble(lower, upper));
        }
        return tempArray;
    }

    public static double distanceAB(Point2D a, Point2D b) {
        return Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
    }

    public double distanceTo(Point2D point2D) {
        return Math.sqrt(Math.pow((this.getX() - point2D.getX()), 2) + Math.pow((this.getY() - point2D.getY()), 2));
    }

    public static void removeHittedPoints(List<Point2D> list, Point2D testPoint, double radius) {
        ListIterator<Point2D> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Point2D item = listIterator.next();
            if (item.distanceTo(testPoint) < radius) {
                listIterator.remove();
            }
        }
    }
}
