import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Kaleidoscope extends Applet {
  Turtle kamekichi[] = new Turtle[4];
  Rabbit usagi = new Rabbit(kamekichi);
  double px1, py1,px2, py2, px3, py3,px4, py4;;
  double r;
  double deg,deg2 = 0;
  double length;
  boolean flag1=false;
  boolean flag2=false;
  boolean flag3=false;
  boolean flag4=false;

  public void init() {
    kamekichi[0] = new Turtle(300, 100,3,Color.BLACK);
    kamekichi[1] = new Turtle(100, 100,3,Color.BLACK);
    kamekichi[2] = new Turtle(100, 300,3,Color.BLACK);
    kamekichi[3] = new Turtle(300, 300,3,Color.BLACK);
    kamekichi[1].turn(180);
    kamekichi[2].turn(180);
    int[] a = new int[10];
    px1 = 100;
    py1 = 100;
    px2 = 100;
    py2 = 300;
    px3 = 300;
    py3 = 100;
    px4 = 300;
    py4 = 300;
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        if (px1<=e.getX() && e.getX()<=px1+10 && py1<=e.getY() && e.getY()<=py1+10){
          flag1=true;
          repaint();
        }
        if (px2<=e.getX() && e.getX()<=px2+10 && py2<=e.getY() && e.getY()<=py2+10){
          flag2=true;
          repaint();
        }
        if (px3<=e.getX() && e.getX()<=px3+10 && py3<=e.getY() && e.getY()<=py3+10){
          flag3=true;
          repaint();
        }
        if (px4<=e.getX() && e.getX()<=px4+10 && py4<=e.getY() && e.getY()<=py4+10){
          flag4=true;
          repaint();
        }
      }
      public void mouseReleased(MouseEvent e) {
        flag1=false;
        flag2=false;
        flag3=false;
        flag4=false;
      }
    });
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        if (flag1) {
          double dy = e.getY()-py1;
          double dx = e.getX()-px1;
          r = Math.atan2(-dy,-dx);
          deg = r * 180 / Math.PI;
          usagi.turn(deg-deg2);
          length = Math.sqrt(dy*dy + dx*dx);
          usagi.move(length);
          repaint();
          px1 = e.getX();
          py1 = e.getY();
          px2 = e.getX();
          py2 = py2 - dy;
          px3 = px3 - dx;
          py3 = e.getY();
          px4 = px4 - dx;
          py4 = py4 - dy;
          deg2 = deg;
        }
        if (flag2) {
          double dy = e.getY()-py2;
          double dx = -(e.getX()-px2);
          r = Math.atan2(-dy,-dx);
          deg = r * 180 / Math.PI;
          usagi.turn(deg-deg2);
          length = -Math.sqrt(dy*dy + dx*dx);
          usagi.move(length);
          repaint();
          px1 = e.getX();
          py1 = py1 - dy;
          px2 = e.getX();
          py2 = e.getY();
          px3 = px3 + dx;
          py3 = py3 - dy;
          px4 = px4 + dx;
          py4 = e.getY();
          deg2 = deg;
        }
        if (flag3) {
          double dy = e.getY()-py3;
          double dx = -(e.getX()-px3);
          r = Math.atan2(-dy,-dx);
          deg = r * 180 / Math.PI;
          usagi.turn(deg-deg2);
          length = Math.sqrt(dy*dy + dx*dx);
          usagi.move(length);
          repaint();
          px1 = px1 + dx;
          py1 = e.getY();
          px2 = px2 + dx;
          py2 = py2 - dy;
          px3 = e.getX();
          py3 = e.getY();
          px4 = e.getX();
          py4 = py4 - dy;
          deg2 = deg;
        }
        if (flag4) {
          double dy = -(e.getY()-py4);
          double dx = -(e.getX()-px4);
          r = Math.atan2(-dy,-dx);
          deg = r * 180.0 / Math.PI;
          usagi.turn(deg-deg2);
          length = Math.sqrt(dy*dy + dx*dx);
          usagi.move(length);
          repaint();
          px1 = px1 + dx;
          py1 = py1 + dy;
          px2 = px2 + dx;
          py2 = e.getY();
          px3 = e.getX();
          py3 = py3 + dy;
          px4 = e.getX();
          py4 = e.getY();
          deg2 = deg;
        }
      }
    });
  }
  public void paint(Graphics g) {
    usagi.paint(g);
  }
}