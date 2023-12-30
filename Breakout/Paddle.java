import java.awt.event.*;

class Paddle extends Block{

  
  public Paddle(int xp, int yp, int sizep){
    super(xp, yp, sizep);
    this.red = 0;
    this.green = 0;
    this.blue = 0;
    this.alpha = 255;
  }

  public void move(KeyEvent e, int w){
    if(this.x < w - this.size/2)
      if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        this.x += this.size;

    if(this.x > 0)
      if(e.getKeyCode() == KeyEvent.VK_LEFT)
        this.x -= this.size;
  }

  public void moveMouse(int mx){
    this.x = mx;
  }

  
}