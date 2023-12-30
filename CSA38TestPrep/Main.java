class Main {
  // our array
  static int[][] mat = new int[4][4];
  
  public static void main(String[] args) {
    System.out.println("\nuse this link for an image of the output"); 
    System.out.println("https://drive.google.com/file/d/1nipJgTtTeYpMAabD0weFCeD7o_Lb5EL0/view?usp=sharing");
    
    System.out.println("\nwhat is in an array that has not been initialized?");    
    displayMat();

    // TODO complete each of the following
    System.out.println("fillIncreasing");
    //fillIncreasing();
    //displayMat();
    //resetMat();

    System.out.println("fillFirstHalf");
    //fillFirstHalf();
    //displayMat();
    //resetMat();

    System.out.println("fillLastHalf");
    //fillLastHalf();
    //displayMat();
    //resetMat();

    System.out.println("fillDecreasing");
    //fillDecreasing();
    //displayMat();
    //resetMat();

    System.out.println("fillDiagCount");
    //fillDiagCount();
    //displayMat();
    //resetMat();

    System.out.println("fillDiagCount2");
    //fillDiagCount2();
    //displayMat();
    //resetMat();

    System.out.println("fillIncreasing2");
    //fillIncreasing2();
    //displayMat();
    //resetMat();  

    System.out.println("Come up with 3 more of your own");
    
  } // close main

  public static void displayMat(){
    for(int[] row: mat){
      for(int item: row)
        System.out.print(item + " ");
      System.out.println();
    }
    System.out.println();
  } // close displayMat

  public static void resetMat(){
    for(int i = 0; i < mat.length; i++){
      for(int j = 0; j < mat[0].length; j++){
        mat[i][j]=0;
      }
    }
  } // close resetMat


} //close Main