package geom;

import java.awt.Graphics2D;

public class Util {
	public static void centerString(String s, int XPos, int YPos, Graphics2D g2d){
        int stringLen = (int) g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        g2d.drawString(s, XPos - stringLen/2, YPos + g2d.getFontMetrics().getHeight()/2);
	}
}
