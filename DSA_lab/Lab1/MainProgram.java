 public class MainProgram {
	 
	 
	public stastic void (String[] args) {
		task3_1{}
		task3_2{}
	//	task3_3{}
	//	task3_4{}
	 }
 }
 
 
	public static void printlengthofvector (Point2D [] list) {
		
		int N = list.length;
		
	System.out.println("List of points");
	String s = String.format("%4s | %20s ", "IDX", "Point");
	System.out.println(s);
	System.out.println(new String(new char[s.length]));
	
	for(int idx=0; idx < N; idx++){
		s= String.format("%3d | %18s",idx,list[idx]);
		System.out.println(s);
	}
	
	public static void task3_2() {
		int N = 10;
		double min= -10, max = 10;
		Point2D[] listA = Point2Dgenerate(N, min, max)
		Point2D[] listB = Point2Dgenerate(N, min, max)
		double[]distance = new double[N];
		
		for(int idx=0; idx < N; idx++){
			Point2D p1 = listA[idx];
			Point2D p2 = listB[idx];
			distance[idx] = Point2D.distanceAB(p1,p2);
		}
		
		String s = String.format("%3s | %18s, %18s | %6s,"IDX","p1: Point in listA", "p2: Point in list B", " Distance(p1,p2)");
		System.out.print(s);
		System.out.print( new Sting ( new char [ s.length]));
		
		for(int idx=0; idx < N; idx++){
			Point2D p1= listA[idx];
			Point2D p2= listB[idx];
			s= String.format("%4d | %20s. %20s | %6.2f ")
			
			
		}
		
		
	}
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
	}