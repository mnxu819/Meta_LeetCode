You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
The area of an island is the number of cells with a value 1 in the island.
Return the maximum area of an island in grid. If there is no island, return 0.
  
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        boolean isVisited[][] = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!isVisited[i][j] && grid[i][j] == 1) {
                    isVisited[i][j] = true;
                    res = Math.max(res, getCurrentMax(grid, isVisited, i, j));
                }
            }
        }
        return res;
    }
    public int getCurrentMax(int[][] grid, boolean[][] isVisited, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        int area = 1;
        int[] xC = {-1, 1, 0, 0};
        int[] yC = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int k = 0; k < 4; k++) {
                int newX = x + xC[k];
                int newY = y + yC[k];
                if (checkForBoundry(grid, newX, newY) && !isVisited[newX][newY] && grid[newX][newY] == 1) {
                    isVisited[newX][newY] = true;
                    area++;
                    q.offer(new int[]{newX, newY});                   
                }
            }
        }
        return area;
    }
    public boolean checkForBoundry(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
