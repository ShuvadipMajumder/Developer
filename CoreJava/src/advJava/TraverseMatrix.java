// This Java program calculates the number of unique paths from the top-left corner to the bottom-right corner of a matrix
// using dynamic programming. The matrix is represented by its number of rows and columns.
// The program initializes a 2D array to store the number of ways to reach each cell, filling it based on the number of ways
// to reach the cells above and to the left. The final result is found in the bottom-right cell of the matrix. 
public class TraverseMatrix {

    // This method calculates the number of unique paths from the top-left corner to the bottom-right corner of a matrix
    // using dynamic programming.
   public static int numberOfWays(int rows, int cols){
    int dp[][]= new int[rows][cols];
    for (int i=0;i<rows;i++) dp[i][0]=1;
    for (int j=0;j<cols;j++) dp[0][j]=1;
    for (int i=1;i<rows;i++){
        for (int j=1;j<cols;j++){
            dp[i][j] = dp[i-1][j]+ dp[i][j-1];  

        }
    }
    return dp[rows-1][cols-1];

   }


    public static void main(String[] args) {
        int A = 3; // rows
        int B = 3; // columns
        System.out.println("Number of ways to traverse a " + A + "x" + B + " matrix: " + numberOfWays(A, B));
    }

}
