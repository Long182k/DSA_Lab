package geom;
 
import dsa2020.MainFrame;
 
import java.awt.*;
 
public class Graph extends GeomObject {
    public enum GraphMode {
        LINE,
        SCATTER
    }
 
    protected Viewport viewport;
    private Point2D[] point2DS;
    private GraphMode mode = GraphMode.LINE;
 
    //    Constructors
    public Graph(Point2D[] point2DS, double xMin, double xMax, double yMin, double yMax) {
        this.point2DS = point2DS;
        viewport = new Viewport(xMin, xMax, yMin, yMax);
    }
 
    public Graph(Point2D[] point2DS, double xMin, double xMax, double yMin, double yMax, Color color) {
        this.point2DS = point2DS;
        viewport = new Viewport(xMin, xMax, yMin, yMax);
        this.edgeColor = color;
    }
 
    public Graph(Point2D[] points) {
        copyPoints(points);
    }
 
    public Graph(Point2D[] points, Color color) {
        copyPoints(points);
        this.edgeColor = color;
    }
 
    //    Setters
    public void setMode(GraphMode mode) {
        this.mode = mode;
    }
 
    //    Utilities
    private void copyPoints(Point2D[] point2DS) {
        this.point2DS = point2DS;
        this.viewport = new Viewport(point2DS[0].getX(), point2DS[0].getX(), point2DS[0].getY(), point2DS[0].getY());
        for (Point2D point2D : point2DS) {
            this.viewport.addPoint(point2D);
        }
    }
 
    public static Graph sin(SpaceMapping spaceMapping, double a, double xMin, double xMax, double step) {
        int N = (int) ((xMax - xMin) / step) - 1; // Excludes xMax
        Point2D[] point2DS = new Point2D[N];
        double x = xMin;
        for (int idx = 0; idx < N; idx++) {
            int amplifier = 50;
            int elevation = 150;
            point2DS[idx] = new Point2D(
                    x * spaceMapping.sxD2L(),
                    (Math.sin(a * x * Math.PI / 180) * amplifier + elevation) * spaceMapping.syD2L()
            );
            x += step;
        }
        return new Graph(point2DS);
    }
 
    public static Graph quadratic(SpaceMapping spaceMapping, double a, double b, double c, double xMin, double xMax, double step) {
        int N = (int) ((xMax - xMin) / step) - 1; // Excludes xMax
        Point2D[] point2DS = new Point2D[N];
        double x = xMin;
        for (int idx = 0; idx < N; idx++) {
            point2DS[idx] = new Point2D(
                    x * spaceMapping.sxD2L(),
                    (a * x * x + b * x + c) * spaceMapping.syD2L()
            );
            x += step;
        }
        return new Graph(point2DS);
    }
 
    @Override
    public void draw(Graphics g, SpaceMapping mapper) {
        Graphics2D g2d = (Graphics2D) g;
 
        if (this.mode == GraphMode.LINE) {
            if (this.point2DS == null) return;
            int[] x = new int[this.point2DS.length];
            int[] y = new int[this.point2DS.length];
            for (int idx = 0; idx < this.point2DS.length; idx++) {
                Point2D devPoint = mapper.logic2Device(this.point2DS[idx]);
                x[idx] = (int) devPoint.getX();
                y[idx] = (int) devPoint.getY();
            }
            g2d.setColor(this.edgeColor);
            Stroke style = new BasicStroke(this.line_weight);
            g2d.setStroke(style);
            g2d.drawPolyline(x, y, x.length);
        } else if (this.mode == GraphMode.SCATTER) {
            MainFrame.infoPanel.println("Drawing Graph");
            for (Point2D point2D : this.point2DS) {
                System.out.println(point2D);
                point2D.draw(g, mapper);
            }
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}