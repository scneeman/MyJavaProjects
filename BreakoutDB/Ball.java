import java.awt.Color;
import java.awt.Graphics2D;

public class Ball 
{
  private int x, y, size, xV, yV;
  public Ball(int w, int h) {
    this.x = 100;
    this.y = 100;
    this.size = w/20;
    this.xV = (int)(Math.random()*7)-3;
    while(this.xV == 0) {
      this.xV = (int)(Math.random()*20)-3;
    }
    this.yV = (int)(Math.random()*20)-3;
    while(this.yV == 0) {
      this.yV = (int)(Math.random()*7)-3;
    }
  }

  public void draw(Graphics2D g) {
    g.setColor(Color.GREEN);
    g.fillOval(x, y, this.size, this.size);
  }

  public void move(Graphics2D g, Paddle p) {
    if(this.yV > 3) {
      this.yV = 3;
    } 
    if(this.yV < -3) {
      this.yV = -3;
    }

    if(this.x+this.size > Main.getWidth() || this.x < 0) {
      this.xV *= -1;

      if(this.x+this.size > Main.getWidth()) {
        this.x = Main.getWidth()-this.size;
      }

      if(this.x < 0) {
        this.x = 0;
      }
    }

    if(this.y+this.size*2 > Main.getHeight() || this.y < 0) {
      this.yV *= -1;

      if(this.y+this.size*2 > Main.getHeight()) {
        p.loseHealth();
        p.decScore();
        this.y = Main.getHeight()-this.size*2;
      }

      if(this.y < 0) {
        this.y = 0;
      }
    }


    this.x += this.xV;
    this.y += this.yV;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public int getSize() {
    return this.size;
  }

  public void flipY() {
    this.yV *= -1;
  }

  public void addXVelocity(int V) {
    this.xV += V;
    if(this.xV > 3) {
      this.xV = 3;
    }
    if(this.xV < -3) {
      this.xV = -3;
    }
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  
}