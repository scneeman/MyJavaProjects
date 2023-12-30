
//-----------------------------
// do not edit this class
//-----------------------------

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Picture{
  private BufferedImage img;
  private int width;
  private int height;
  Pixel [][] pixels;

  public Picture(String filename){
      File f = null;
      //read image
      try{
         f = new File(filename);
         this.img = ImageIO.read(f);
      }catch(IOException e){
         System.out.println(e);
      }
 
      this.width = img.getWidth();
      this.height = img.getHeight();
      
      // create a 2D list of pixels in ?? form
      this.pixels = new Pixel[this.height][this.width];
      for(int row = 0; row < this.height; row++)
         for(int col = 0; col < this.width; col++)
            this.pixels[row][col] = new Pixel(img.getRGB(col, row));
   
   } // close Picture() constructor
   
   // getters
   public int getWidth(){
      return this.width;
   }
   public int getHeight(){
      return this.height;
   }  
   
   // output to a new file
   public void output(String filename){
      // set values in image back to new array??
      for (int row = 0; row < this.height; row++)
         for (int col = 0; col < this.width; col++)
            this.img.setRGB(col, row, this.pixels[row][col].getValue());
   
      //write image
      try{
         File f = new File(filename);
         ImageIO.write(this.img, "jpg", f);
      }catch(IOException e){
         System.out.println(e);
      } 
   } // close output()

} // close Picture class


