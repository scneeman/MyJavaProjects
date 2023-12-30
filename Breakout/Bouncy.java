import java.awt.Color;
import java.awt.Graphics;

class Bouncy{
  private int x, y, size, xV, yV, red, green, blue;
  
  public Bouncy(int sizep){
    this.x = 100;
    this.y = 100;
    this.size = sizep;
    // never allow zero velocity
    this.xV = 0;
    while(this.xV==0)
      this.xV = (int)(Math.random()*7-3);

    this.yV = 0;
    while(this.yV == 0)
      this.yV = (int)(Math.random()*7-3);

    this.red = (int)(Math.random()*255);
    this.green = (int)(Math.random()*255);
    this.blue = (int)(Math.random()*255);    
  }

  public void draw(Graphics g){
    g.setColor(new Color(this.red, this.green, this.blue));
    g.fillOval(this.x, this.y, this.size, this.size);
  }

  public void move(int w, int h){
    if(this.x < 0 || this.x + this.size > w)
      this.xV *= -1;
    if(this.y < 0 || this.y + this.size >h)
      this.yV *= -1;

    this.x += this.xV;
    this.y += this.yV;
  }

  public void checkCollision(Paddle pad){
    if(this.x > pad.getX() && this.x < pad.getX() + pad.getSize())
      if(this.y + this.size > pad.getY())
        this.yV *= -1;
  }

  public boolean checkCollision(Block b){
    if(this.x > b.getX() && this.x < b.getX() + b.getSize()){
      if(this.y > b.getY() && this.y < b.getY() + b.getSize()/5){
        this.yV *= -1;
        return true;
      }
    }
    return false;
  }
  
}