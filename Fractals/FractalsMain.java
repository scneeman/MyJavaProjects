import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Polygon;

public class FractalsMain extends Canvas{

  // setup variables
  static int w, h;

  // setup the frame
  public static void main(String[] args){
    w = 600;
    h = 600;
    JFrame frame = new JFrame("Fractal H Tree");
    Canvas canvas = new FractalsMain(); // this must match the file/class name
    canvas.setSize(w,h);
    frame.add(canvas);
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  // 
  public void paint(Graphics g){
    drawH(g, w/2, h/2, 200, Color.black);  
    //drawIllusion(g, 300, 50, 300, 250);
  }


  
  public static int sumRec(int num){
    if(num == 1)
      return 1;
    else
      return num + sumRec(num-1);
  }

  public static void helloRec(int num){
    if(num > 0){
      helloRec(num-1);
      System.out.println("hello" + num);
    }
  }

  public static int sum(int num){
    int total = 0;
    for(int i = 1; i <= num; i++){
      total = total + i;
    }
    return total;
  }



  
  
  public void drawH(Graphics g, int x, int y, int size, Color col){
    g.setColor(col);
    g.drawLine(x-size/2, y, x+size/2, y);
    g.drawLine(x-size/2, y-size/2, x-size/2, y+size/2);
    g.drawLine(x+size/2, y-size/2, x+size/2, y+size/2);
    delay(10);
    if (size>10){
       int randR = (int)(Math.random()*256);
       int randG = (int)(Math.random()*256);
       int randB = (int)(Math.random()*256);
       Color randCol = new Color(randR, randG, randB);
       drawH(g, x-size/2, y-size/2, size/2, randCol);
       drawH(g, x-size/2, y+size/2, size/2, randCol);
       drawH(g, x+size/2, y-size/2, size/2, randCol);
       drawH(g, x+size/2, y+size/2, size/2, randCol);
    }
  }

  public void drawIllusion(Graphics g, int x1, int y1, int x2, int y2){ 
    g.drawLine(x1, y1, x2, y2);
    delay(200);
    if(y1<y2){
      y1+=10;
      x2+=10;
      drawIllusion(g, x1, y1, x2, y2);
    }
 }//close method
 
  public void drawSquare(Graphics g, int x1, int y1, int size){
    g.drawRect(x1, y1, size, size);
    
    if(size>5){
      size/=2;
      drawSquare(g, x1, y1, size);
    }
 }//close method
 
 public void drawSquare2(Graphics g, int x1, int y1, int size){
    g.drawRect(x1, y1, size, size);
    if(size>10){
      size-=20;
      x1+=10;
      y1+=10;
      drawSquare2(g, x1, y1, size);
    }
 }//close method

  public void drawSierpenskiCarpet(Graphics g, Color c, int x, int y, int size){
    //draw the 'main' square in the center
    int sub = size/3;
    
    g.setColor(c);
    g.fillRect(x+sub, y+sub, sub, sub);
    //delay(1);
    //draw the eight sub-squares around it
    if(size > 2){
      Color temp = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
      drawSierpenskiCarpet(g, temp, x, y, sub);
      drawSierpenskiCarpet(g, temp, x+sub, y, sub);
      drawSierpenskiCarpet(g, temp, x+2*sub, y, sub);
       
      drawSierpenskiCarpet(g, temp, x, y+sub, sub);
      drawSierpenskiCarpet(g, temp, x+2*sub, y+sub, sub);
       
      drawSierpenskiCarpet(g, temp, x, y+2*sub, sub);
      drawSierpenskiCarpet(g, temp, x+sub, y+2*sub, sub);
      drawSierpenskiCarpet(g, temp, x+2*sub, y+2*sub, sub);
    }//close if
    
 }//close method
 
  public void drawSierpenskiCarpetBW(Graphics g, int x, int y, int size){
    //draw the 'main' square in the center
    int sub = size/3;
    g.fillRect(x+sub, y+sub, sub, sub);
    
    //draw the eight sub-squares around it
    if(size > 1){
      drawSierpenskiCarpetBW(g, x, y, sub);
      drawSierpenskiCarpetBW(g, x+sub, y, sub);
      drawSierpenskiCarpetBW(g, x+2*sub, y, sub);
     
      drawSierpenskiCarpetBW(g, x, y+sub, sub);
      drawSierpenskiCarpetBW(g, x+2*sub, y+sub, sub);
     
      drawSierpenskiCarpetBW(g, x, y+2*sub, sub);
      drawSierpenskiCarpetBW(g, x+sub, y+2*sub, sub);
      drawSierpenskiCarpetBW(g, x+2*sub, y+2*sub, sub);
    }//close if

 }//close method
 
 
  public void drawSierpenski(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3){
    int x4 = (x1+x3)/2;
    int y4 = (y1+y3)/2;
    int x5 = (x1+x2)/2;
    int y5 = (y1+y2)/2;
    int x6 = (x2+x3)/2;
    int y6 = (y2+y3)/2;
    
    Polygon poly = new Polygon();
    poly.addPoint(x4, y4);
    poly.addPoint(x5, y5);
    poly.addPoint(x6, y6);
    g.fillPolygon(poly);
    
    if(Math.abs(x1-x4)>2){
      drawSierpenski(g, x1, y1, x4, y4, x5, y5);
      drawSierpenski(g, x5, y5, x2, y2, x6, y6);
      drawSierpenski(g, x4, y4, x6, y6, x3, y3);
    }
 
  }//close method


  public static void delay(int n){
    try{
      Thread.sleep(n);
    }
    catch (InterruptedException e){}
  }



}