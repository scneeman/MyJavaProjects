import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.*; // for the keyboard listener

class StickMain extends Canvas implements KeyListener{
  // variables for the Canvas size
  static int w = 400;
  static int h = 300;
  public StickMan man = new StickMan(w, h, 100); // my object, you can change the size

  // for the keyboard listener
  public StickMain(){
    addKeyListener(this);
  }

  // setup the frame
  public static void main(String[] args){
    // standard setup stuff
    JFrame frame = new JFrame("My Drawing");
    Canvas canvas = new StickMain(); // this must match the file/class name
    canvas.setSize(w,h);
    canvas.setBackground(new Color(255,255,255));
    
    frame.getContentPane().add(new StickMain()); // needed for the KeyListener
    frame.add(canvas);
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  } // close main

  // this is where the action happens
  public void paint(Graphics g){
    man.draw(g);
    delay(10);
    repaint();       
  } // close paint


  // a helper method
  public static void delay(int n){
    try{
        Thread.sleep(n);
    }
    catch (InterruptedException e){}
  } // close delay

 
  // KeyListener methods
  public void keyTyped(KeyEvent e){}
  public void keyReleased(KeyEvent e){}
  public void keyPressed(KeyEvent event){
    if (event.getKeyCode() == KeyEvent.VK_RIGHT)
      man.move_right();
    if (event.getKeyCode() == KeyEvent.VK_LEFT)
      man.move_left();  
  }
    
} // close class




class StickMan{
  private int x, y, size, ticks;

  public StickMan(int w, int h, int size){
    this.size = size;
    this.x = w/2;
    this.y = h-3*size/4;
    this.ticks = 0;
  }

  public void draw(Graphics g){
    // body
    g.drawLine(x, y, x, y+size/2);
    // head
    int dia = size/4;
    g.drawOval(x-dia/2, y-dia, dia, dia);
    int inc = size/40; // movement increment of arms and legs
    // arms
    g.drawLine(x, y+dia/2, x+(5-ticks)*inc, y+6*dia/5);
    g.drawLine(x, y+dia/2, x-(5-ticks)*inc, y+6*dia/5);
    // legs
    g.drawLine(x, y+size/2, x+(5-ticks)*inc, y+size/2+6*dia/5);
    g.drawLine(x, y+size/2, x-(5-ticks)*inc, y+size/2+6*dia/5);
  }

  public void move_right(){
    this.ticks = (this.ticks+1)%5;
    this.ticks++;
    this.x+=2;
  }

  public void move_left(){
    this.ticks = (this.ticks+1)%5;
    this.ticks++;
    this.x-=2;
  }

}