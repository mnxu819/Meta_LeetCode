Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
  
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int row = m-1;
        int col = 0;
        int res = 0;
        //和10那个题不同，从左下开始
        while (row >= 0 && col <= n-1) {
            if (grid[row][col] < 0) {
                res += n - col;
                row--;
            } else {
                col++;
            }
        }
        return res;
    }
}
