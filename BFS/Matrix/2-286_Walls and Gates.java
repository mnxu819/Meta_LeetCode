You are given an m x n grid rooms initialized with these three possible values.

-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
  
class Solution {
    final int INF = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length;
        int n = rooms[0].length;
        int[] xCoord = {0, 0, -1, 1};
        int[] yCoord = {-1, 1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
   
        // find all the gate and put into the queue, in the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                   q.offer(new int[]{i, j});
                }
            }
        }
        //此bfs是先遍历所有gate，再遍历所有距离gate为1的，所有为2的，所以保证所有空房间都是距离gate最近的
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int k = 0; k < 4; k++) {
                int newX = x + xCoord[k];
                int newY = y + yCoord[k];
                if (checkB(rooms, newX, newY) && rooms[newX][newY] == INF) {
                    //if it's the empty room, distance is its prvious room distance plus 1
                    //it happens when room is next to gate, gate is 0, so plus one is 1
                    rooms[newX][newY] = rooms[x][y]+1;
                    q.offer(new int[]{newX, newY});
                }
            }   
        }
    }
    public boolean checkB(int[][] rooms, int i , int j) {
        return i>=0 && j >=0 && i <rooms.length && j < rooms[0].length;
    }
}
