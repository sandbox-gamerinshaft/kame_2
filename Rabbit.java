import java.util.*;
import java.awt.*;
import java.applet.Applet;

public class Rabbit {
  Turtle kame[];
  Rabbit(Turtle k[]) {
    kame = k;
  }

  public void paint(Graphics g){
    for (int i = 0; i < 4; i++){
      g.setColor(Color.BLACK);
      g.fillOval(kame[i].getX(),kame[i].getY(),10,10);
      kame[i].paint(g);
    }
  }
  void turn(double deg) {
    kame[0].turn(deg);
    kame[1].turn(-deg);
    kame[2].turn(deg);
    kame[3].turn(-deg);
  }
  void move(double length){
    for (int i = 0; i < 4; i++){
      kame[i].move(length);
    }
  }
}

