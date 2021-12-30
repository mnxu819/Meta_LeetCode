Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.
  
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid.length == 0 || grid[0][0] != 0 || grid[n-1][n-1] != 0) {
            return -1;
        }
        int[] xCoord = {0, 0 ,1, -1, -1 ,-1, 1, 1};
        int[] yCoord = {1, -1, 0, 0, -1, 1, -1, 1};
        
        Queue<int[]> q =new LinkedList<>();
        boolean[][] isVisited = new boolean[n][n];
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            isVisited[x][y] = true;
            int distance = grid[x][y];
            if (x == n-1 && y == n-1) {
                return distance+1;
            }
            for (int k = 0; k < 8; k++) {
                int newX = x + xCoord[k];
                int newY = y + yCoord[k];
                if (checkB(grid, newX, newY) &&  !isVisited[newX][newY] && grid[newX][newY] == 0) {
                    q.offer(new int[]{newX, newY});
                    grid[newX][newY] = distance+1;
                }
            }
        }
        return -1;
    }
    public boolean checkB(int[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
