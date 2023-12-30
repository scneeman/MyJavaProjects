import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.event.*;


public class BreakoutMain extends Canvas implements KeyListener, MouseMotionListener{
  // variables for the Canvas size
  static int w, h;

  // TODO create a 'Bouncy' object
  static Bouncy ball;
  static Paddle pad;

  // TODO create a list of 'Blocks'
  static ArrayList<Block> blocks = new ArrayList<Block>();

  public BreakoutMain(){
    addKeyListener(this);
    addMouseMotionListener(this);
  }
  

  // setup the frame
  public static void main(String[] args){
    // the Canvas size
    w = 400;
    h = 300;
    int s2 = (int)(w/40);
    ball = new Bouncy(s2);
    pad = new Paddle(w/2, (int)(0.8*h), w/5);
    // standard setup stuff
    JFrame frame = new JFrame("My Drawing");
    Canvas canvas = new BreakoutMain(); // this must match the file/class name
    canvas.setSize(w,h);
    canvas.setBackground(new Color(255,255,255));
    frame.add(canvas);
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // TODO initialize the blocks
    for(int i = 0; i<100; i++){
      int s = (int)(w/20);
      int x = (int)(Math.random()*(w-s));
      int y = (int)(Math.random()*h/5);
      blocks.add(new Block(x,y,s));
    }
 
    
  } // close main

  // this is where the action happens
  public void paint(Graphics g){
    // TODO call your methods here
  
    ball.draw(g);
    ball.move(w, h);
    pad.draw(g);
    
    for(Block b: blocks)
      b.draw(g);

    for(int i = 0; i < blocks.size(); i++){
      if(ball.checkCollision(blocks.get(i)))
        blocks.remove(i);
    }
      

    ball.checkCollision(pad);

    delay(5);
    repaint(); 

  } // close paint


  public static void delay(int n){
    try{
      Thread.sleep(n);
    }
    catch(InterruptedException e){}
  } // close delay


  // required for KeyListener
  public void keyTyped(KeyEvent e){}
  public void keyReleased(KeyEvent e){}
  public void keyPressed(KeyEvent e){
    //pad.move(e, w);
  }

  // required for MouseMotionListener
  public void mouseDragged(MouseEvent e){}
  public void mouseMoved(MouseEvent e){
    pad.moveMouse(e.getX());
  }
  

} // close class
