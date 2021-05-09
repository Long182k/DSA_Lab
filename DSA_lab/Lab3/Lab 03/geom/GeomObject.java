package geom;
import java.awt.Color;
import java.awt.Graphics;

import dsa2020.SpaceMapping;

public abstract class GeomObject {
	protected Color edgeColor;
	protected Color faceColor;
	protected int line_weight = 3;
	
	public GeomObject(){
		edgeColor = new Color(20, 200, 20);
		faceColor = Color.RED;
	}
	
	public void setLineWeight(int w) {
		this.line_weight = w;
	}
	
	public void setFaceColor(Color color) {
		this.faceColor = color;
	}
	
	public void setEdgeColor(Color color) {
		this.edgeColor = color;
	}
	
	public Color getFaceColor() {
		return faceColor;
	}
	
	public Color getEdgeColor() {
		return edgeColor;
	}
	
	public abstract void draw(Graphics g, SpaceMapping mapper);
}
