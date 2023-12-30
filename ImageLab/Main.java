//https://stackoverflow.com/questions/17174906/convert-a-bufferedimage-into-a-2d-array
//https://dyclassroom.com/image-processing-project/how-to-get-and-set-pixel-value-in-java
//https://dyclassroom.com/image-processing-project/how-to-convert-a-color-image-into-grayscale-image-in-java


public class Main{  
   
  public static void main(String args[]){
    // from the --Picture-- class we can access:
    // the width and height (using getWidth() and getHeight())
  
    // from the --Pixel-- class we can access:
    // individually red, green, or blue (using getRed(), etc)
    // the ARGB integer value (using getARGB(), which is a 32-bit integer)
      
    // we can set:
    // individually red, green, or blue (using setRed(), etc)
    // the ARGB integer value (using setARGB())
    // the red, green, and blue color (using setRGB())      
    
    //---------- examples
    // each of these receive two parameters:
    // the Picture object and the output filename
    speckle(new Picture("download.jpg"), "outputSpeckle.jpg");
    //greyscale(new Picture("download.jpg"), "outputGS.jpg");
    //blackBox(new Picture("download.jpg"), "outputBB.jpg");
    //flipAcrossVertical(new Picture("download.jpg"), "outputFlipV.jpg");
    //rot180(new Picture("download.jpg"), "outputRot180.jpg");
      
    //---------- assignment
    //reduceRed(new Picture("download.jpg"), "outputReduceRed.jpg");
    //negate(new Picture("download.jpg"), "outputNegate.jpg"); 
    //flipAcrossHorizontal(new Picture("download.jpg"), "outputFAH.jpg");
    //mirror(new Picture("download.jpg"), "outputMirror.jpg");
    //popArt(new Picture("download.jpg"), "outputPopArt.jpg");
      
      
           
  } // close main()

  // assignment #5
  public static void popArt(Picture myPic, String filename){
    // top left, don't touch
    // top right, enhance red
    for(int row = 0; row<myPic.getHeight()/2; row++){
      for(int col = myPic.getWidth()/2; col<myPic.getWidth(); col++){
        int r = myPic.pixels[row][col].getRed();
        int g = myPic.pixels[row][col].getGreen();
        int b = myPic.pixels[row][col].getBlue();
        int newR = (r+50)%255;
        myPic.pixels[row][col].setRGB(newR,g,b);
      }
    }
    // bottom left, enhance green
    for(int row = myPic.getHeight()/2; row<myPic.getHeight(); row++){
      for(int col = 0; col<myPic.getWidth()/2; col++){
        int r = myPic.pixels[row][col].getRed();
        int g = myPic.pixels[row][col].getGreen();
        int b = myPic.pixels[row][col].getBlue();
        int newG = (g+50)%255;
        myPic.pixels[row][col].setRGB(r,newG,b);
      }
    }
    // bottom right, enhance blue
    for(int row = myPic.getHeight()/2; row<myPic.getHeight(); row++){
      for(int col = myPic.getWidth()/2; col<myPic.getWidth(); col++){
        int r = myPic.pixels[row][col].getRed();
        int g = myPic.pixels[row][col].getGreen();
        int b = myPic.pixels[row][col].getBlue();
        int newB = (b+50)%255;
        myPic.pixels[row][col].setRGB(r,g,newB);
      }
    }
    myPic.output(filename);
  } 


  // assignment #4
  public static void mirror(Picture myPic, String filename){
    for(int row = 0; row<myPic.getHeight(); row++){
      for(int col = 0; col<myPic.getWidth()/2; col++){
        
        int val = myPic.pixels[row][col].getValue();
        myPic.pixels[row][myPic.getWidth()-col-1].setARGB(val);
        
        /*
        int r = myPic.pixels[row][col].getRed();
        int g = myPic.pixels[row][col].getGreen();
        int b = myPic.pixels[row][col].getBlue();
        myPic.pixels[row][myPic.getWidth()-col-1].setRGB(r,g,b);
        */
        
      }
    }
    myPic.output(filename);
  }  
  
  


  // assignment #3
  public static void flipAcrossHorizontal(Picture myPic, String filename){
    for(int row = 0; row<myPic.getHeight()/2; row++){
      for(int col = 0; col<myPic.getWidth(); col++){
        int topVal = myPic.pixels[row][col].getValue();
        int bottomVal = myPic.pixels[myPic.getHeight()-1-row][col].getValue();
        int tempVal = topVal;
        myPic.pixels[row][col].setARGB(bottomVal);
        myPic.pixels[myPic.getHeight()-1-row][col].setARGB(tempVal);
      }
    }
    myPic.output(filename);
  }  


  // assignment #2
  public static void negate(Picture myPic, String filename){
    for(int row = 0; row<myPic.getHeight(); row++){
      for(int col = 0; col<myPic.getWidth(); col++){
        int r = myPic.pixels[row][col].getRed();
        int g = myPic.pixels[row][col].getGreen();
        int b = myPic.pixels[row][col].getBlue();
        int newR = 255-r;
        int newG = 255-g;
        int newB = 255-b;
        myPic.pixels[row][col].setRGB(newR,newG,newB);     
      }
    }
    myPic.output(filename);
  }
  
   
  // assignment #1
  public static void reduceRed(Picture myPic, String filename){
    for(int row = 0; row<myPic.getHeight(); row++){
      for(int col = 0; col<myPic.getWidth(); col++){
        int r = myPic.pixels[row][col].getRed();
        int g = myPic.pixels[row][col].getGreen();
        int b = myPic.pixels[row][col].getBlue();
        int newR = r-50;
        if (newR<0) newR=0;
        myPic.pixels[row][col].setRGB(newR,g,b);     
      }
    }
    myPic.output(filename);
  }

  // this shows how we can access any pixel
  public static void speckle(Picture myPic, String filename){
    for(int i = 0; i < 10000; i++){
      int row = (int)(Math.random()*myPic.pixels.length);
      int col = (int)(Math.random()*myPic.pixels[0].length);
      int r = (int)(Math.random()*255);
      int g = (int)(Math.random()*255);
      int b = (int)(Math.random()*255);
      myPic.pixels[row][col].setRGB(r,g,b);
      
    }
    myPic.output(filename);
  }

  // this shows how we can access all pixels
  // and their individual red, green, and blue values
  // then set the pixel to a specific RGB
  public static void greyscale(Picture myPic, String filename){
    for(int row = 0; row<myPic.pixels.length; row++){
      for(int col = 0; col < myPic.pixels[0].length; col++){
        int r = myPic.pixels[row][col].getRed();
        int g = myPic.pixels[row][col].getGreen();
        int b = myPic.pixels[row][col].getBlue();
        int avg = (int)((r+g+b)/3);
        myPic.pixels[row][col].setRGB(avg,avg,avg);
        
      }
      myPic.output(filename);
    }
      
  } // close greyscale()

  
   
  // this shows how we can access a portion of the image
  // and set the pixels to a specific RGB
  public static void blackBox(Picture myPic, String filename){
    for(int row = 0; row<myPic.pixels.length/2; row++){
      for(int col = 0; col<myPic.pixels[0].length/2; col++){
        myPic.pixels[row][col].setRGB(0,0,0);
      }
    }
    myPic.output(filename);

  } // close blackBox()


  
   
  // this shows how we can access all of the pixels
  // and get the ARGB value
  // and swap with a different location
  public static void flipAcrossVertical(Picture myPic, String filename){
    for(int row = 0; row < myPic.pixels.length; row++){
      for(int col = 0; col < myPic.pixels[0].length/2; col++){
        int leftVal = myPic.pixels[row][col].getValue();
        int rightVal = myPic.pixels[row][myPic.pixels[0].length-1-col].getValue();
        int temp = leftVal;
        myPic.pixels[row][col].setARGB(rightVal);
        myPic.pixels[row][myPic.pixels[0].length-1-col].setARGB(temp);
      }
    }
    myPic.output(filename);
    
  } // close flipAcrossVertical()

  
  public static void rot180(Picture myPic, String filename){
    for(int row = 0; row < myPic.getHeight()/2; row++){
      for(int col = 0; col < myPic.getWidth(); col++){
        int leftVal = myPic.pixels[row][col].getValue();
        int rightVal = myPic.pixels[myPic.getHeight()-1-row][myPic.getWidth()-1-col].getValue();
        int temp = leftVal;
        myPic.pixels[row][col].setARGB(rightVal);
        myPic.pixels[myPic.getHeight()-1-row][myPic.getWidth()-1-col].setARGB(temp);
      }
    }
    myPic.output(filename);
  }
     
                
} // close runnable class

