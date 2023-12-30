import java.awt.Color;
import java.awt.Graphics;

class Block{
  public int x, y, size, red, green, blue, alpha;
  
  public Block(int xp, int yp, int sizep){
    this.x = xp;
    this.y = yp;
    this.size = sizep;
    this.red = (int)(Math.random()*255);
    this.green = (int)(Math.random()*255);
    this.blue = (int)(Math.random()*255);
    this.alpha = (int)(Math.random()*255);
  }

  public void draw(Graphics g){
    g.setColor(new Color(this.red, this.green, this.blue, this.alpha));
    g.fillRect(this.x, this.y, this.size, this.size/5);
  }

  public int getX(){
    return this.x;
  }

  public int getSize(){
    return this.size;
  }

  public int getY(){
    return this.y;
  }


}