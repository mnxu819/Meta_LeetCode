Given two Sparse Matrix A and B, return the result of AB.
You may assume that A's column number is equal to B's row number.
  
public class Solution {
    /**
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        // write your code here
        int n = A[0].length;
        int[][] ans = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < n; k++) {
                    ans[i][j] += A[i][k]*B[k][j];
                }    
            }
        }
        return ans;
    }
}  
