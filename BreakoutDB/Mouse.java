import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.PointerInfo;
import java.awt.Point;

class Listener implements MouseListener 
{
  private boolean leftClicked = false;

  private int x, y;

  public Listener() {
    this.x = 0;
    this.y = 0;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean getLeftClick() {
    return leftClicked;
  }

  public void setXLoc(MouseEvent e) {
    this.x = (int)e.getX();
  }

  public void setYLoc(MouseEvent e) {
    this.y = (int)e.getY();
  }

  public void mouseClicked(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
    if(e.getButton() == MouseEvent.BUTTON1)
      this.leftClicked = false;
  }

  public void mousePressed(MouseEvent e) {
    if(e.getButton() == MouseEvent.BUTTON1)
      this.leftClicked = true;
  }

  public void mouseEntered(MouseEvent e) {
    
  }
}

public class Mouse extends Listener implements MouseMotionListener {

  public Mouse() {
    super();
  }
  public void mouseDragged(MouseEvent e) {
    
  }

  public void mouseMoved(MouseEvent e) {
    this.setXLoc(e);
    this.setYLoc(e);
  }
}