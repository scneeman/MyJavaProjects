import java.awt.Color;
import java.awt.Graphics2D;

public class Block
  {
    private int x, y, size;
    private int red = (int)(Math.random()*255);
    private int green = (int)(Math.random()*255);
    private int blue = (int)(Math.random()*255);
    private Color col = new Color(red, green, blue);
    
    public Block(int x, int y, int size) {
      this.x = x;
      this.y = y;
      this.size = size;
    }

    public void draw(Graphics2D g) {
      g.setColor(col);
      g.fillRect(this.x, this.y, this.size, this.size/5);
    }

    public boolean touchingBall(Ball b) {
      if(b.getX()+b.getSize() > this.x && b.getX() < this.x+this.size && b.getY()+b.getSize() > this.y && b.getY() < this.y+this.size/5) {
        b.flipY();
        return true;
      }
      return false;
    }

    
  }