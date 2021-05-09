package dsa2020;

import geom.Point2D;

public class SpaceMapping {
	private int minDevX, maxDevX, minDevY, maxDevY;
	private double minLogX, maxLogX, minLogY, maxLogY;
	
	public SpaceMapping() {
		minDevX = 0;
		minDevY = 0;
		maxDevX = 800;
		maxDevY = 600;
		
		minLogX = 0;
		minLogY = 0;
		maxLogX = 1;
		maxLogY = 1;
	}
	
	public double wD() {
		return maxDevX - minDevX;
	}
	
	public double hD() {
		return maxDevY - minDevY;
	}
	
	public double wL() {
		return maxLogX - minLogX;
	}
	
	public double hL() {
		return maxLogY - minLogY;
	}
	
	public double sxL2D() {
		return wD() / wL();
	}
	
	public double syL2D() {
		return hD() / hL();
	}
	
	public double sxD2L() {
		return wL() / wD();
	}
	
	public double syD2L() {
		return hL() / hD();
	}
	
	public Point2D oLinD() {
		return new Point2D(
				this.minDevX - this.minLogX * this.sxL2D(),
				this.maxDevY + this.minLogY * this.syL2D()
				);
	}
	
	public double step() {
		return 5.0 * Math.min(this.sxD2L(), this.syD2L());
	}
	
    public double stepX(int pixels){
        return pixels * this.sxD2L();
    }
    
    public double stepY(int pixels){
        return pixels * this.syD2L();
    }
	
	public void updateDevViewPort(int minDevX, int maxDevX, int minDevY, int maxDevY){ 
		this.minDevX = minDevX;
		this.maxDevX = maxDevX;
		this.minDevY = minDevY;
		this.maxDevY = maxDevY;
	}
	
	public void updateLogViewPort(double minLogX, double maxLogX, double minLogY, double maxLogY){
		this.minLogX = minLogX;
		this.maxLogX = maxLogX;
		this.minLogY = minLogY;
		this.maxLogY = maxLogY;
	}
	
	public void updateLogViewPort(Viewport vp) {
		if(vp == null)
			return;
		this.minLogX = vp.getxMin();
		this.maxLogX = vp.getxMax(); 
		this.minLogY = vp.getyMin();
		this.maxLogY = vp.getyMax();
	}
	
	public Point2D device2Logic(Point2D devPoint){ 
		return device2Logic((int)devPoint.getX(), (int)devPoint.getY());
	}
	
	public Point2D device2Logic(int devX, int devY){
		double txD2L = this.oLinD().getX() * sxD2L();
		double tyD2L = - this.oLinD().getY() * syD2L(); // "-" means flipped 
		double logX = sxD2L()*devX - txD2L; 
		double logY = -syD2L()*devY - tyD2L; 
		return new Point2D(logX, logY); 
	}
	
	public Point2D logic2Device(Point2D logPoint){ 
		return logic2Device(logPoint.getX(), logPoint.getY()); 
	}
	
	public Point2D logic2Device(double logX, double logY){ 
		double txL2D = this.oLinD().getX();
		double tyL2D = -this.oLinD().getY();
		double devX = sxL2D()*logX + txL2D;
		double devY = -syL2D()*logY - tyL2D; 
		return new Point2D(devX, devY);
	}
}
