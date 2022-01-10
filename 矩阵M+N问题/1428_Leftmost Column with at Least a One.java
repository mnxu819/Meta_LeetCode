A row-sorted binary matrix means that all elements are 0 or 1 and each row of the matrix is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return the index (0-indexed) of the leftmost column with a 1 in it. If such an index does not exist, return -1.

You can't access the Binary Matrix directly. You may only access the matrix using a BinaryMatrix interface:
BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
BinaryMatrix.dimensions() returns the dimensions of the matrix as a list of 2 elements [rows, cols], which means the matrix is rows x cols.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes, the input will be the entire binary matrix mat. You will not have access to the binary matrix directly.
  
0000111
0001111
0011111
0000011
0000001
  
/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
     public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int m = binaryMatrix.dimensions().get(0);
        int n = binaryMatrix.dimensions().get(1);
        int i = 0;
        int j = n-1;
         // start from right top
         while (i < m && j >= 0) {
             if (binaryMatrix.get(i, j) == 0) {
                 i++;
             } else {
                 j--;
             }
         }
         return j == n-1 ? -1 : j+1;
     }
    /*
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        //O(NlogM)
        int res = Integer.MAX_VALUE;
        int m = binaryMatrix.dimensions().get(0);
        int n = binaryMatrix.dimensions().get(1);
        for (int i = 0; i < m; i++) {
            int start = 0;
            int end = n-1;
            while (start + 1 < end) {
                int mid = start + (end - start)/2;
                if (binaryMatrix.get(i, mid) == 1) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (binaryMatrix.get(i, start) == 1) {
                res = Math.min(res, start);
            } else if (binaryMatrix.get(i, end) == 1) {
                res = Math.min(res, end);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    */
}
