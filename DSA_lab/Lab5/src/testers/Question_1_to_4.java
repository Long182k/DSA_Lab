package testers;
import java.util.List;
import java.util.ListIterator;

import list.DLinkedList;
import list.ListDemo;
import list.ListEval;
import list.MyArrayList;
import list.SLinkedList;
import list.other.Point2D;

public class Question_1_to_4 {
	public static void main(String[] args) {
		question1();
		System.out.println();
		question2();
		System.out.println();
		question3();
		System.out.println();
		question4();
	}
	
	public static void question1() {
		System.out.println("MyArrayList Demo:");
		ListDemo.demo(new MyArrayList<>());
		System.out.println();
		System.out.println("SLinkedList Demo:");
		ListDemo.demo(new SLinkedList<>());
		System.out.println();
		System.out.println("DLinkedList Demo:");
		ListDemo.demo(new DLinkedList<>());
	}
	
	public static void question2() {
		System.out.println("MyArrayList modification using Iterator:");
		ListDemo.demoModification1(new MyArrayList<Integer>());
		System.out.println();
		System.out.println("MyArrayList modification using index and for loop:");
		ListDemo.demoModification2(new MyArrayList<Integer>());
		System.out.println();
		
		System.out.println("SLinkedList modification using Iterator:");
		ListDemo.demoModification1(new SLinkedList<Integer>());
		System.out.println();
		System.out.println("SLinkedList modification using index and for loop:");
		ListDemo.demoModification2(new SLinkedList<Integer>());

		System.out.println("DLinkedList modification using Iterator:");
		ListDemo.demoModification1(new DLinkedList<Integer>());
		System.out.println();
		System.out.println("DLinkedList modification using index and for loop:");
		ListDemo.demoModification2(new DLinkedList<Integer>());
	}
	
	public static void question3() {
		int n = 10;
		Point2D[] points = Point2D.generate(n, -10, 10);
		
		// MyArrayList
		List<Point2D> myArrayList = new MyArrayList<Point2D>();
		for(Point2D p : points)
			myArrayList.add(p);
		System.out.println("Original MyArrayList: ");
		for(Point2D p : myArrayList)
			System.out.println(p);
		removeHittedPoints(myArrayList, new Point2D(0, 0), 6);
		System.out.println();
		System.out.println("Modified MyArrayList: ");
		for(Point2D p : myArrayList)
			System.out.println(p);
		
		System.out.println();
		
		// SLinkedList
		List<Point2D> sLinkedList = new SLinkedList<Point2D>();
		for(Point2D p : points)
			sLinkedList.add(p);
		System.out.println("Original SLinkedList: ");
		for(Point2D p : sLinkedList)
			System.out.println(p);
		removeHittedPoints(sLinkedList, new Point2D(0, 0), 6);
		System.out.println();
		System.out.println("Modified SLinkedList: ");
		for(Point2D p : sLinkedList)
			System.out.println(p);
		
		System.out.println();
		
		// DLinkedList
		List<Point2D> dLinkedList = new DLinkedList<Point2D>();
		for(Point2D p : points)
			dLinkedList.add(p);
		System.out.println("Original SLinkedList: ");
		for(Point2D p : dLinkedList)
			System.out.println(p);
		removeHittedPoints(dLinkedList, new Point2D(0, 0), 6);
		System.out.println();
		System.out.println("Modified SLinkedList: ");
		for(Point2D p : dLinkedList)
			System.out.println(p);
	}
	
	private static void removeHittedPoints(List<Point2D> list, Point2D testPoint, double radius) {
		ListIterator<Point2D> it = list.listIterator();
		while(it.hasNext()) {
			Point2D p = it.next();
			if(p.distanceTo(testPoint) < radius)
				it.remove();
		}
	}
	
	public static void question4() {
		@SuppressWarnings("rawtypes")
		List[] listOfLists = {
				new MyArrayList<>(),
				new SLinkedList<>(),
				new DLinkedList<>()
		};
		
		System.out.println(String.format("%s\t\t\t%s\t\t%s\t%s", "List", "Get(i)", "Add To Head", "Add to Tail"));
		for(int i = 0; i<listOfLists.length; i++) {
			@SuppressWarnings("unchecked")
			List<Integer> l = listOfLists[i];
			double accessing = ListEval.evaluateAccessing(l, 10000, 1000);
			double addHead = ListEval.evaluateAddingHead(l, 50000, 10);
			double addTail = ListEval.evaluateAddingTail(l, 50000, 10);
			System.out.println(String.format("%s\t%f\t%f\t%f", l.getClass().getName(), accessing, addHead, addTail));
		}
	}
}
