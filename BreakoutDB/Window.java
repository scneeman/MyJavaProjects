import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Window extends JPanel 
{

  private int w = Main.getWidth();
  private int h = Main.getHeight();

  private Ball b = new Ball(h, w);
  private Paddle p = new Paddle();
  
  private boolean firstTime = true;
  private boolean win = false;

  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    BufferedImage bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2D = bufferedImage.createGraphics();
    Graphics2D g2dComponent = (Graphics2D) g;

    this.draw(g2D);

    if(Main.blocks.isEmpty()) {
      this.win = true;
    }
    
    g2dComponent.drawImage(bufferedImage, null, 0, 0);
  }

  public void draw(Graphics2D g) 
  {
    
    if(!firstTime) {
      if(!win) {
        if(p.isAlive()) {
          b.draw(g);
          b.move(g, p);
          p.draw(g);
          p.touchingBall(b);
          for(int i = 0; i < Main.blocks.size(); i++) {
            Main.blocks.get(i).draw(g);
            if(Main.blocks.get(i).touchingBall(b)) {
              Main.blocks.remove(i);
              p.incScore();
            }
          }
        } else {
          this.loseScreen(g);
        }
      } else {
          this.winScreen(g);
        }
      } else {
          this.StartUI(g);
    }
    repaint();
    delay(10);
  }

  public void delay(int n) 
  {
     try {
            Thread.sleep(n);
        }
        catch (Exception e) {
            System.out.println(e);
        }
  }

  public void StartUI(Graphics2D g) {
    g.setColor(Color.RED);
        g.setFont(new Font("arial", Font.PLAIN, 30));
        g.drawString("BreakOut", this.w/2-75, this.h/4);
        g.setFont(new Font("arial", Font.PLAIN, 20));
        g.drawString("Start", this.w/2-30, this.h/2);
        g.setColor(Color.BLACK);
        g.drawRect(this.w/2-31, this.h/2-18, 51, 20);

        int mX = Main.mouse.getX();
        int mY = Main.mouse.getY();
        if(mX > this.w/2-31 && mX < this.w/2-31+51 && mY < this.h/2+20 && mY > this.h/2 && Main.mouse.getLeftClick()) {
          this.firstTime = false;
        }
  }

  public void winScreen(Graphics2D g) {  
      g.setColor(Color.RED);
      g.setFont(new Font("arial", Font.PLAIN, 30));
      g.drawString("You Win!", this.w/2-75, this.h/4);
    g.setFont(new Font("arial", Font.PLAIN, 20));
      g.drawString("Score: " + p.getScore(), this.w/2-30, this.h/2);
    
  }

  public void loseScreen(Graphics2D g) {  
      g.setColor(Color.RED);
      g.setFont(new Font("arial", Font.PLAIN, 30));
      g.drawString("GameOver!", this.w/2-75, this.h/4);
      g.setFont(new Font("arial", Font.PLAIN, 20));
      g.drawString("Score: " + p.getScore(), this.w/2-30, this.h/2);
    
  }
}