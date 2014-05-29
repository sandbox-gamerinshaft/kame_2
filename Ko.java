import java.util.*;
import java.awt.*;
import java.applet.Applet;

public class Ko extends Applet {
  Turtle kamekichi; // 「亀吉」用インスタンス変数の宣言
  public void init() {
    setBackground(Color.white); // アプレットの背景色を白に設定
    kamekichi = new Turtle(200,200,2,Color.BLUE);  // 「亀吉」の生成
    ko(kamekichi);  //三角形（その2）
    // cabbage(kamekichi, 40);
    //square(kamekichi);  // 「亀吉」を正方形に動かす

  }

  void cabbage(Turtle t, int size){
    int i,j;
    for (i = 3; i <= 10; i++) {
      j = 0;
      while(i > j){
        t.move(size);
        t.turn(360.0/i);
        j++;
      }
    }
  }

  void ko(Turtle t) {
    for (int i = 0; i < 3; i++) {
      t.move(50);
      t.turn(90);
    }
  }
  // 三角形の回転を行うメソッド

  void triangles(Turtle t, int n, int c, int d) {
    for (int i = 0; i++ < n; ) {
      triangle(t, i * c);
      t.turn(d);
    }
  }

  void triangle(Turtle t, int size) {
    for(int i = 0; i < 3; i++){
      t.move(size);
      t.turn(120);
    }
  }

  public void paint(Graphics g) {
    kamekichi.paint(g); // 「亀吉」に足跡を描かせる
  }

}

