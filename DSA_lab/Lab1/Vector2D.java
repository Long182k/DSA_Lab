import java.util.Vector;
import java.util.List;
import java.util.*;
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


public class Vector2D {
	public double x;
	public double y;
}

	private double x;
	private double y;


public Vector2D(){
	this.x=1;
	this.y=0;	
}

public Vector2D(double x, double y){
	this.x=x;
	this.y=y;
}

public Vector2D( Vector2D oldPoint ){
	this.x=oldPoint.x;
	this.y=oldPoint.y;
}


public Vector2D clone(){	
	return new Vector2D(this.x,this.y)
}

public String toString(){
	return String.format("V(%6.2f, %6.2f)", this.x, this.y);
}

public Vector2D a2b(Point2D a, Point2D b){
	double x = b.getX() - a.getX();
	double y = b.getY() - a.getY();
	return new Vector2D(x,y);
}











