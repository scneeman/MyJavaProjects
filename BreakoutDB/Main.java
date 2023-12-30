import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.ArrayList;

class Main {
    public static ArrayList<Block> blocks = new ArrayList<Block>();

    private static int w = 400;
    private static int h = 300;
    private static JFrame frame = null;
    public static Mouse mouse = new Mouse();
  
  public static void main(String[] args) {
    Window window = new Window();
    frame = new JFrame("Breakout");
    frame.addMouseListener(mouse);
    frame.addMouseMotionListener(mouse);
    addBlocks(10);

    frame.setSize(w, h);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(window, BorderLayout.CENTER);
    frame.setVisible(true);
  }

  public static int getWidth() {
    return w;
  }

  public static int getHeight() {
    return h;
  }

  public static void quit() {
    frame.dispose();
  }

  public static void addBlocks(int n) {
    for(int i = 0; i < n; i++) {
      int s = w/5;
      int x = (int)(Math.random()*w);
      while(x+s > w || x < 0) {
        x = (int)(Math.random()*w);
      }
      int y = (int)(Math.random()*h/5);
      blocks.add(new Block(x, y, s));
    }
  }
}