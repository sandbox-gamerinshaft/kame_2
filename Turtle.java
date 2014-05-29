import java.util.*;
import java.awt.*;
import java.applet.Applet;
import javax.swing.*;

public class Turtle{
  double x, y;
  double angle;
  double rd = Math.PI / 180;
  int size;
  Color color;
  ArrayList<Point2> points = new ArrayList<Point2>();
  Turtle(int i, int j, int s, Color c){
    x = i; y = j; angle = 0; size = s; color = c;
    points.add(new Point2((int)x, (int)y, size, color));
  }
  public void move(double length){
    x = x + length * Math.cos(rd * angle);
    y = y - length * Math.sin(rd * angle);
    points.add(new Point2((int)Math.round(x), (int)Math.round(y), size, color ));
  }
  public void turn(double deg){
    angle = angle + deg;
  }

  public int getX(){
    return (int)Math.round(x);
  }

  public int getY(){
    return (int)Math.round(y);
  }

  public void penSize(int s){
    size = s;
    points.add(new Point2((int)Math.round(x), (int)Math.round(y), size, color ));
  }

  public void penColor(Color c){
    color = c;
    points.add(new Point2((int)Math.round(x), (int)Math.round(y), size, color ));
  }

  public void paint(Graphics g){
    Graphics2D g2 = (Graphics2D)g;
    Point2 pt1, pt2;
    for(int i=0; i<points.size()-1; i++){
      pt1 = points.get(i);
      pt2 = points.get(i+1);
      BasicStroke wideStroke = new BasicStroke(pt1.size);
      g2.setStroke(wideStroke);
      g.setColor(pt1.color);
      g.drawLine(pt1.x, pt1.y, pt2.x, pt2.y);
    }
  }
}