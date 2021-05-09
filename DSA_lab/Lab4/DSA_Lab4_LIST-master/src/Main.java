import geom.Point2D;
import list.MyArrayList;
import list.SLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("===================================================java.util.ArrayList====================================================");

        Point2D[] point2DS = Point2D.generatePoint2D(30);
        List<Point2D> point2DList = new ArrayList<>(Arrays.asList(point2DS));

        showResults(point2DList);

        System.out.println("\n================================================MyArrayList Implementation================================================");

        point2DS = Point2D.generatePoint2D(30);
        List<Point2D> point2DMyArrayList = new MyArrayList<>(Arrays.asList(point2DS));

        showResults(point2DMyArrayList);

        System.out.println("\n================================================SLinkedList Implementation================================================");

        point2DS = Point2D.generatePoint2D(30);
        List<Point2D> point2DSLinkedList = new SLinkedList<>(Arrays.asList(point2DS));

        showResults(point2DSLinkedList);
    }

    private static void showResults(List<Point2D> point2DList) {
        System.out.println("Before modification: ");
        System.out.println(point2DList);

        Point2D.removeHittedPoints(point2DList, new Point2D(5, 5), 5);

        System.out.println("After modification: ");
        System.out.println(point2DList);
    }
}
