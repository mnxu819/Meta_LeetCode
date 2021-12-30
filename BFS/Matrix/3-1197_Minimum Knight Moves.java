In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
Return the minimum number of steps needed to move the knight to the square [x, y]. It is guaranteed the answer exists.
  
class Solution {
    public int minKnightMoves(int x, int y) {
        int[] xCoord = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        int[] yCoord = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[610][610];
        visited[300][300] = true;
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];
                if (curX == x && curY == y) {
                    return res;
                }
                for (int k = 0; k < 8; k++) {
                    int newX = curX + xCoord[k];
                    int newY = curY + yCoord[k];
                    if (checkB(newX, newY, visited)) {               
                        q.offer(new int[]{newX, newY});
                        visited[newX+300][newY+300] = true;
                    }
                }
            }
            res++;
        }
        return res;
    }
    public boolean checkB(int x, int y, boolean[][] visited) {
        if (x < -300 || x > 300) return false;
        if (y < -300 || y > 300) return false;
        if (Math.abs(x) + Math.abs(y) > 300) return false;
        return !visited[x+300][y+300];
    }
}
