Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all 
four edges of the grid are all surrounded by water.
  
class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] v = new boolean[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!v[i][j] && grid[i][j] == '1') {
                    bfs(v, grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    public void bfs(boolean[][] v, char[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        int[] xC = {-1, 1, 0, 0};
        int[] yC = {0, 0, 1, -1};
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int k = 0; k < 4; k++) {
                int newX = x + xC[k];
                int newY = y + yC[k];
                if (checkB(grid, newX, newY) && !v[newX][newY] && grid[newX][newY] == '1') {
                    v[newX][newY] = true;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
    }
    public boolean checkB(char[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
