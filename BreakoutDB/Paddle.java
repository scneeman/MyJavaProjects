import java.awt.Graphics2D;
import java.awt.Color;


public class Paddle 
{
  private int x, y, size, height, velocity, health, score, incNum;
  
  
  public Paddle() {
    size = 120;
    height = size/8;
    health = 100;
    score = 0;
    incNum = 0;
    y = Main.getHeight() - 75;
    x = Main.getWidth()/2-size;  
  }

  public void draw(Graphics2D g) 
  {
    int previousX = this.x;
    g.setColor(Color.BLACK);
    x = Main.mouse.getX() - this.size/2;

    String healthNum = "Health: " + health;
    String scoreNum = "Score: " + score;

    this.velocity = this.x-previousX;
    g.fillRect(x, y, size, height);
    g.drawString(healthNum, 5, Main.getHeight()-25);
    g.drawString(scoreNum, Main.getWidth() - 80, Main.getHeight()-25);
  }

  public void touchingBall(Ball b) {
      if(b.getX()+b.getSize() > this.x && b.getX() < this.x+this.size && b.getY()+b.getSize() > this.y && b.getY() < this.y+this.size/8) {
        b.flipY();
        b.addXVelocity(this.velocity);
      }
    }

  public int getVelocity() {
    return velocity;
  }

  public void loseHealth() {
    health -= 10;
    size -= 10;
  }

  public boolean isAlive() {
    return (health > 0);
  }

  public void incScore() {
      score++;
  }

  public void decScore() {
    score--;
  }

  public int getScore() {
    return score;
  }
}