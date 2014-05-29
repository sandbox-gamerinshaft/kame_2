import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Kaleidoscope extends Applet {
    Turtle kamekichi[] = new Turtle[4];
    Rabbit usagi = new Rabbit(kamekichi);
    int px, py;
    double r;
    double deg,deg2 = 0;
    double length; 
    boolean flag=false;
    public void init() {
	kamekichi[0] = new Turtle(300, 100,2,Color.black);
	kamekichi[1] = new Turtle(100, 100,2,Color.black);
	kamekichi[2] = new Turtle(100, 300,2,Color.black); 
	kamekichi[3] = new Turtle(300, 300,2,Color.black);
	kamekichi[1].turn(180);
	kamekichi[2].turn(180);
	px = 100;
	py = 100;
	addMouseListener(new MouseAdapter() {
		public void mousePressed(MouseEvent e) {
		    if (px<=e.getX() && e.getX()<=px+10 &&
			py<=e.getY() && e.getY()<=py+10)
			flag=true;
		    
		    repaint();
		}
		public void mouseReleased(MouseEvent e) {
		    flag=false;
		}
	    }
			 );

	addMouseMotionListener(new MouseMotionAdapter() {
		public void mouseDragged(MouseEvent e) {
		    if (flag) {
			double dy = e.getY()-py;
			double dx = e.getX()-px;
			r = Math.atan2(-dy,-dx);
			deg = r * 180 / Math.PI;
			usagi.turn(deg-deg2);
			length = Math.sqrt(dy*dy + dx*dx);
			usagi.move(length);
			repaint();
			px = e.getX();
			py = e.getY();
			deg2 = deg;
		    }
		}
	    }			       
			       );
    }
    public void paint(Graphics g) {
	usagi.paint(g);
    }
}