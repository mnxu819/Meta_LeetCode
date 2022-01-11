You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
Determine the perimeter of the island.
  
class Solution {
    public int islandPerimeter(int[][] grid) {
        //周长等于总的岛屿的个数X4-相邻的个数X2
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        int neighbor = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    total++;
                    if (i+1 < m && grid[i+1][j] == 1) neighbor++;
                    if (j+1 < n && grid[i][j+1] == 1) neighbor++;
                }
            }
        }
        return 4*total-2*neighbor;
    }
}
