import java.awt.Graphics;

class MyDesigns{

  public static void delay(int n){
    try{
      Thread.sleep(n);
    }
    catch(InterruptedException e){}
  } // close delay

  public static void illusion(Graphics g, int x1, int y1, int size){
    int x2 = x1;
    int y2 = y1 + size;
    int gap = (int)(size/20);
    while(y1 <= y2){
      g.drawLine(x1, y1, x2, y2);
      delay(100);
      x2 += gap;
      y1 += gap;
    }
  }
  
} // close class
