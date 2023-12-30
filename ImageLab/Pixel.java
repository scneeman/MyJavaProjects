//-----------------------------
// do not edit this class
//-----------------------------

public class Pixel{
   // this is a 32-bit integer in ARGB form
   private int value;
   
   public Pixel(int val){
      this.value = val;      
   } // close Pixel() constructor
   
   // getters
   public int getRed(){
      return (this.value>>16)&0xff;
   }  
   public int getGreen(){
      return (this.value>>8)&0xff;
   }  
   public int getBlue(){
      return this.value&0xff;
   }
   public int getValue(){
      return this.value;
   }
   
   // the setters
   public void setRed(int r){
      // a, r, g, b are integers between 0, 255
      int a = (this.value>>24)&0xff;
      int g = (this.value>>8)&0xff;
      int b = this.value&0xff;
      
      // convert back to integer ARGB form
      int p = (a<<24) | (r<<16) | (g<<8) | b;
      this.value = p;
   } // close setRed()

   public void setGreen(int g){
      // a, r, g, b are integers between 0, 255
      int a = (this.value>>24)&0xff;
      int r = (this.value>>16)&0xff;
      int b = this.value&0xff;
      
      // convert back to integer ARGB form
      int p = (a<<24) | (r<<16) | (g<<8) | b;
      this.value = p;
   } // close setGreen()
   
   public void setBlue(int b){
      // a, r, g, b are integers between 0, 255
      int a = (this.value>>24)&0xff;
      int r = (this.value>>16)&0xff;
      int g = (this.value>>8)&0xff;
      
      // convert back to integer ARGB form
      int p = (a<<24) | (r<<16) | (g<<8) | b;
      this.value = p;
   } // close setBlue()  
   
   public void setRGB(int r, int g, int b){
      int a = (this.value>>24)&0xff;
      // convert back to integer ARGB form
      int p = (a<<24) | (r<<16) | (g<<8) | b;
      this.value = p;
   } // close setRGB()


   public void setARGB(int p){
      this.value = p;
   } // close setRGB()    
} // close Pixel class