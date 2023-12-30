class TPSMain {
  // our array
  static int[][] mat = new int[4][4];
  public static void main(String[] args) {
    System.out.println("\nwhat is in an array that has not been initialized?");    
    displayMat();

    System.out.println("fillIncreasing");
    fillIncreasing();
    displayMat();
    resetMat();

    System.out.println("fillFirstHalf");
    fillFirstHalf();
    displayMat();
    resetMat();

    System.out.println("fillLastHalf");
    fillLastHalf();
    displayMat();
    resetMat();

    System.out.println("fillDecreasing");
    fillDecreasing();
    displayMat();
    resetMat();

    System.out.println("fillDiagCount");
    fillDiagCount();
    displayMat();
    resetMat();

    System.out.println("fillDiagCount2");
    fillDiagCount2();
    displayMat();
    resetMat();

    System.out.println("fillIncreasing2");
    fillIncreasing2();
    displayMat();
    resetMat();  

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

  public static void fillIncreasing(){
    for(int i = 0; i < mat.length; i++){
      for(int j = 0; j < mat[0].length; j++){
        mat[i][j]=j;
      }
    }
  } // close fill0123

  public static void fillDecreasing(){
    for(int i = 0; i<mat.length; i++){
      for(int j = 0; j<mat[0].length; j++){
        mat[i][j] = mat[0].length-j-1;
      }
    }
  } // close fill3210

  public static void fillDiagCount(){
    int count = 1;
    for(int i = 0; i<mat.length; i++){
      for(int j = i; j<mat[0].length; j++){
        mat[i][j] = count;
      }
      count++;
    }
  }

  public static void fillDiagCount2(){
    int count = 1;
    for(int i = 0; i<mat.length; i++){
      for(int j = i; j<mat[0].length; j++){
        mat[i][j] = count;
        count++;
      }
      count=1;
    }
  }

  public static void fillIncreasing2(){
    int start = 1;
    for(int i = 0; i<mat.length; i++){
      int count = start;
      for(int j = 0; j<mat[0].length; j++){
        mat[i][j] = count;
        count++;
      }
      start++;
    }
  }

  public static void fillFirstHalf(){
    int count = 1;
    for(int i = 0; i<mat.length; i++){
      for(int j = 0; j<mat[0].length/2; j++){
        mat[i][j] = count;
        count++;
      }
      count=1;
    }
  }

  public static void fillLastHalf(){
    int count = 1;
    for(int i = 0; i<mat.length; i++){
      for(int j = mat[0].length/2; j<mat[0].length; j++){
        mat[i][j] = count;
        count++;
      }
      count=1;
    }
  }

} //close Main