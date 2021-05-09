

public double getX();{
	return x;
}

public void setX(double x) {
	this.x= x;
}


public double getY();{
	return y;
}

public void setY(double y) {
	this.y= y;
}


public class Point2D {
	public double x;
	public double y;
}

	private double x;
	private double y;


public Point2D(){
	this.x=0;
	this.y=0;
}

public Point2D(double x, double y){
	this.x=x;
	this.y=y;
}

public Point2D( Point2D oldPoint ){
	this.x=oldPoint.x;
	this.y=oldPoint.y;
}


public Point2D clone(){	
	return new Point2D(this.x,this.y)
}

public String toString(){
	return String.format("P(%6.2f, %6.2f)", this.x, this.y);
}

public static Point2D[] generate(int N, double min, double max) {
	
	Random generator = new Random();
	Point2D [] list= new Point2D[N];
	for(int idx=0; idx < N; idx++){
		double  x = min + generator.nextDouble()*(max)
		double  y = min + generator.nextDouble()*(max)
	list[idx] = new Point2D(x,y);
	}
	return list;
}


public static double distanceAB(Point2D a, Point2D b) {
	double dx= a.getX() - b.getX();
	double dy= a.getY() - b.getY();
	return Math.sqrt(dx*dx + dy*dy);
}

public double distanceTo(Point2D point){
	double dx = this.getX() - point.getX();
	double dy = this.getY() - point.getY();
}

