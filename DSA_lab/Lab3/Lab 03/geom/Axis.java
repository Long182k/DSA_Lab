package geom;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import dsa2020.SpaceMapping;
import dsa2020.Viewport;

public class Axis extends GeomObject {
	
	private String xLabel = "x", yLabel = "y";
	
	public Axis() {
		
	}
	
	public Axis(String xLabel, String yLabel) {
		this.xLabel = xLabel;
		this.yLabel = yLabel;
	}
	
	public void setLabel(String xLabel, String yLabel) {
		this.xLabel = xLabel;
		this.yLabel = yLabel;
	}
	
	Viewport viewport;
	
	public void addViewport(Viewport viewport) {
		if(this.viewport == null)
			this.viewport = viewport.clone();
		else
			this.viewport.combine(viewport);
	}
	
	public Viewport getViewport() {
		return viewport;
	}
	
	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}

	@Override
	public void draw(Graphics g, SpaceMapping mapper) {
		if(viewport == null)
			return;
		
		Graphics2D g2 = (Graphics2D) g;
		
		Point2D bl = mapper.logic2Device(viewport.getxMin(), viewport.getyMin()); // bottom left
		Point2D br = mapper.logic2Device(viewport.getxMax(), viewport.getyMin()); // bottom right
		Point2D tl = mapper.logic2Device(viewport.getxMin(), viewport.getyMax()); // top left
		
		g2.setColor(Color.black);
        Stroke style = new BasicStroke(2);
        g2.setStroke(style);
        g2.drawLine((int) bl.getX(), (int) bl.getY(), (int) br.getX(), (int) br.getY());
        g2.drawLine((int) bl.getX(), (int) bl.getY(), (int) tl.getX(), (int) tl.getY() + 20);
        
        int x = (int) bl.getX();
        int y = (int) bl.getY();
        int spacingPixels = 50;
        
        while(x < br.getX()) {
        	Point2D logicPoint = mapper.device2Logic(x, y);
            g2.setColor(Color.BLACK);
            Util.centerString(String.format("%.2f", logicPoint.getX()), x, y + 15, g2);
            g2.setColor(Color.WHITE);
        	g2.drawLine(x, y, x, y + 5);
        	x += spacingPixels;
        }
        
        x = (int) bl.getX();
        
        while(y > tl.getY()) {
        	Point2D logicPoint = mapper.device2Logic(x, y);
            g2.setColor(Color.BLACK);
            Util.centerString(String.format("%.2f", logicPoint.getY()), x - 25, y, g2);
            g2.setColor(Color.WHITE);
        	g2.drawLine(x, y, x - 5, y);
        	y -= spacingPixels;
        }
        
        // Draw label
        g2.setColor(Color.black);
        Util.centerString(xLabel, (int)br.getX() + 50, (int)br.getY(), g2);
        Util.centerString(yLabel, (int)tl.getX(), (int)tl.getY(), g2);
	}

}
