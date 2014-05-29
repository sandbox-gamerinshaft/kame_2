import java.util.*;
import java.awt.*;
import java.applet.Applet;
import javax.swing.*;

public class TurtleApplet extends Applet {
   Turtle kamekichi;	// 「亀吉」用インスタンス変数の宣言
    
   public void init() {
      setBackground(Color.WHITE); // アプレットの背景色を白に設定
      kamekichi = new Turtle(200,400,1,Color.BLACK);	// 「亀吉」の生成
      square(kamekichi);	// 「亀吉」を正方形に動かす
   }

  
    void square(Turtle s){
	for (int i = 3; i <= 10; i++){
	    for (int j = 0; j < i; j++){
		s.move(100);
		s.turn(360.0/i);
		s.penSize(5);
		s.penColor(Color.red);
	    }
	}
    }
    


   public void paint(Graphics g) {
      kamekichi.paint(g); // 「亀吉」に足跡を描かせる
   }
}