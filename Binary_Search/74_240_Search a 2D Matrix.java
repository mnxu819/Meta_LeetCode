Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
  
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
  
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m*n-1;
        while (start + 1 < end) {
            int mid = start + (end-start)/2;
            if (matrix[mid/n][mid%n] == target) {
                return true;
            } else if (matrix[mid/n][mid%n] < target) {
                start = mid;
            } else 
                end = mid;
        }
        if (matrix[start/n][start%n] == target || matrix[end/n][end%n] == target) {
            return true;
        } else 
            return false;
    }
}
/******************************************************************************************
Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else 
                return true;
        }
        return false;
    }
}
