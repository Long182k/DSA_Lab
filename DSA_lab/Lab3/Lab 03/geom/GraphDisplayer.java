package geom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import dsa2020.SpaceMapping;
import dsa2020.Viewport;
import geom.Graph.GraphMode;

public class GraphDisplayer extends GeomObject {
	
	private Axis axis = new Axis();
	private List<Graph> graphs = new ArrayList<Graph>();
	
	public Viewport getViewport() {
		return axis.getViewport();
	}
	
	public void addGraph(Graph graph, String name, Color color, GraphMode mode) {
		graph.setEdgeColor(color);
		graph.setFaceColor(color);
		graph.setName(name);
		graph.setMode(mode);
		graphs.add(graph);
	}
	
	public void clear() {
		graphs.clear();
	}

	@Override
	public void draw(Graphics g, SpaceMapping mapper) {
		axis.draw(g, mapper);
		for(Graph graph : graphs)
			graph.draw(g, mapper);
	}
	
	public void showLegends(Graphics g, int x, int y) {
		for(Graph graph : graphs) {
			g.setFont(new Font ("Courier New", 1, 15));
			g.setColor(graph.getFaceColor());
			g.fillRect(x, y - 10, 15, 15);
			g.setColor(Color.BLACK);
			g.drawRect(x, y - 10, 15, 15);
			g.drawString(graph.getName(), x + 30, y);
			y += g.getFontMetrics().getHeight() * 1.5;
		}
	}
	
	public void setAxisLabel(String xl, String yl) {
		axis.setLabel(xl, yl);
	}
	
	public void resetAxis() {
		axis = new Axis();
		for(Graph g : graphs)
        	axis.addViewport(g.getViewport());
	}

}
