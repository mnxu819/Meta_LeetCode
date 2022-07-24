You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
  
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
  
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
  
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
       
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                     q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if(freshCount == 0) return 0;
        int count = 0;
        int[] xC = {0, 0, -1, 1};
        int[] yC = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] x = q.poll();
                for (int k = 0; k < 4; k++) {
                    int newX = x[0] + xC[k];
                    int newY = x[1] + yC[k];
                    if (checkB(grid, newX, newY) && grid[newX][newY] == 1) {
                        q.offer(new int[]{newX, newY});
                        grid[newX][newY] = 2;
                        freshCount--;
                    }
                }
            }
            count++;
        }
        return freshCount == 0 ? count-1 : -1;
    }
    public boolean checkB(int[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
