package geom;
 
import java.awt.*;
 
public abstract class GeomObject {
    protected Color edgeColor;
    protected Color faceColor;
    protected int line_weight = 1;
 
    public GeomObject() {
        this.faceColor = new Color(20, 200, 20);
        this.edgeColor = new Color(200, 20, 20);
    }
 
    public void setEdgeColor(Color edgeColor) {
        this.edgeColor = edgeColor;
    }
 
    public void setFaceColor(Color faceColor) {
        this.faceColor = faceColor;
    }
 
    public abstract void draw(Graphics g, SpaceMapping mapper);
}