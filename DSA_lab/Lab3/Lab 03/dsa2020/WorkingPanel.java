/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa2020;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import geom.Graph;
import geom.Graph.GraphMode;
import geom.GraphDisplayer;
import geom.Point2D;
import sorting.BubbleSort;
import sorting.ISort;
import sorting.ShellSort;
import sorting.SortingEval;
import sorting.StraightInsertionSort;
import sorting.StraightSelectionSort;

/**
 *
 * @author LTSACH
 */
@SuppressWarnings("serial")
public class WorkingPanel extends JPanel
        implements MouseMotionListener, MouseListener,
        ItemListener,
        ActionListener, ComponentListener
{
	GraphDisplayer displayer = new GraphDisplayer();
	private SpaceMapping spaceMapping;
	
    public WorkingPanel(){
        this.setBorder(BorderFactory.createEtchedBorder()); 
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.addComponentListener(this);
        spaceMapping = new SpaceMapping();
    }
    
    /*
     * Bubble Sort is the worst because when the elements are not in place, 
     * 	it always swap two consecutive elements, 
     * 	which takes more time to complete, and the worst case is when the list is sorted in the reversed order,
     *  then it has to swap lots of times to complete
     * 
     * Shell Sort is the best because it's like Insertion Sort but it has multiple phases,
     *  this will save a lot of time because the phases are preparing so
     *  the elements are in relatively good places for the last phase, the straight insertion sort.
     */
    
    @SuppressWarnings("rawtypes")
	public void initiateGraphs() {
    	displayer.clear();
        
        int[] num_segments = {1, 3, 7};
		ISort[] algorithms = {
			new StraightInsertionSort<Point2D>(),
			new ShellSort<Point2D>(num_segments),
			new StraightSelectionSort<Point2D>(),
			new BubbleSort<Point2D>()
		};
		Point2D[][] plots = new Point2D[algorithms.length][];
		for(int aIdx=0; aIdx < algorithms.length; aIdx++)
			plots[aIdx] = SortingEval.timeit(algorithms[aIdx], 500, 100);
		
		displayer.addGraph(new Graph(plots[0]), "Straight Insertion Sort", Color.red, GraphMode.SCATTER);
		displayer.addGraph(new Graph(plots[1]), "Shell Sort", Color.green, GraphMode.SCATTER);
		displayer.addGraph(new Graph(plots[2]), "Straight Selection Sort", Color.blue, GraphMode.SCATTER);
		displayer.addGraph(new Graph(plots[3]), "Bubble Sort", Color.cyan, GraphMode.SCATTER);
		displayer.resetAxis();
		displayer.setAxisLabel("# Element", "Time (ms)");
    }
    
    
    @Override 
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    
    	if(displayer != null) {
    		spaceMapping.updateLogViewPort(displayer.getViewport());
    		displayer.draw(g, spaceMapping);
    		displayer.showLegends(g, 100, 100);
    	}
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    	Point2D logPoint = spaceMapping.device2Logic(new Point2D(e.getX(), e.getY()));
        String message = String.format("mouseDragged: Device(x, y) = (%d, %d), Logic(x, y) = (%.2f, %.2f)", 
        		e.getX(), e.getY(), logPoint.getX(), logPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    	Point2D logPoint = spaceMapping.device2Logic(new Point2D(e.getX(), e.getY()));
        String message = String.format("mouseMoved: Device(x, y) = (%d, %d), Logic(x, y) = (%.2f, %.2f)", 
        		e.getX(), e.getY(), logPoint.getX(), logPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if((e.getClickCount() == 2) && !e.isConsumed()){
        	Point2D logPoint = spaceMapping.device2Logic(new Point2D(e.getX(), e.getY()));
            String message = String.format("mouseDoubleClicked: Device(x, y) = (%d, %d), Logic(x, y) = (%.2f, %.2f)", 
            		e.getX(), e.getY(), logPoint.getX(), logPoint.getY());
            MainFrame.infoPanel.println(message);
            e.consume();
        }
        else{
        	Point2D logPoint = spaceMapping.device2Logic(new Point2D(e.getX(), e.getY()));
            String message = String.format("mouseClicked: Device(x, y) = (%d, %d), Logic(x, y) = (%.2f, %.2f)", 
            		e.getX(), e.getY(), logPoint.getX(), logPoint.getY());
            MainFrame.infoPanel.println(message);
        }
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        Point2D logPoint = this.spaceMapping.device2Logic(e.getX(), e.getY());
        String message = String.format("mousePressed: Device(x,y)=(%d,%d); Logic(x,y)=(%6.2f, %6.2f)",
            e.getX(), e.getY(),
            logPoint.getX(), logPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point2D logPoint = this.spaceMapping.device2Logic(e.getX(), e.getY());
        String message = String.format("mouseReleased: Device(x,y)=(%d,%d); Logic(x,y)=(%6.2f, %6.2f)",
            e.getX(), e.getY(),
            logPoint.getX(), logPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Point2D logPoint = this.spaceMapping.device2Logic(e.getX(), e.getY());
        String message = String.format("mouseEntered: Device(x,y)=(%d,%d); Logic(x,y)=(%6.2f, %6.2f)",
            e.getX(), e.getY(),
            logPoint.getX(), logPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Point2D logPoint = this.spaceMapping.device2Logic(e.getX(), e.getY());
        String message = String.format("mouseExited: Device(x,y)=(%d,%d); Logic(x,y)=(%6.2f, %6.2f)",
            e.getX(), e.getY(),
            logPoint.getX(), logPoint.getY());
        MainFrame.infoPanel.println(message);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int state = e.getStateChange();
        if(state == ItemEvent.SELECTED){
            MainFrame.infoPanel.println("Selected");
            MainFrame.btnSelect.setText("Selecting");
        }
        else{
            MainFrame.infoPanel.println("DeSelected");
            MainFrame.btnSelect.setText("Drawing");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == MainFrame.btnCircle){
            MainFrame.infoPanel.println("action: draw Circle");
        }
        else if(e.getSource() == MainFrame.btnRect){
            MainFrame.infoPanel.println("action: draw Rect");
        }
        else if(e.getSource() == MainFrame.bthGraph) {
        	initiateGraphs();
        	repaint();
        }
    }

	@Override
	public void componentResized(ComponentEvent e) {
		Dimension size = this.getSize();
		int xGap = 50, yGap = 20;
		spaceMapping.updateDevViewPort(xGap, size.width-2*xGap, yGap, size.height-2*yGap);
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		Dimension size = this.getSize();
		int xGap = 50, yGap = 20;
		spaceMapping.updateDevViewPort(xGap, size.width-2*xGap, yGap, size.height-2*yGap);
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
	}
}
