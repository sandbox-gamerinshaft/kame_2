import java.util.*;
import java.awt.*;
import java.applet.Applet;

public class TurtleApplet1 extends Applet {
    Turtle kamekichi1,kamekichi2;	// 「亀吉」用インスタンス変数の宣言
    
    public void init() {
	setBackground(Color.white); // アプレットの背景色を白に設定
	kamekichi1 = new Turtle(200,100);	// 「亀吉」の生成
	kamekichi2 = new Turtle(200,400);
	triangles(kamekichi1,40,2,10);
	triangles(kamekichi2,40,2,20);
    }
    
    void triangles(Turtle t, int n, int c, int d) {
	for (int i = 0; i++ < n; ) {
	    triangle(t, i * c);
	    t.turn(d);
	}
    }
    
    void triangle(Turtle t, double size) {
	t.move(size);
	t.turn(120);
	t.move(size);
	t.turn(120);
	t.move(size);
	t.turn(120);
    }
    public void paint(Graphics g){
	kamekichi1.paint(g);
	kamekichi2.paint(g);
    }
}