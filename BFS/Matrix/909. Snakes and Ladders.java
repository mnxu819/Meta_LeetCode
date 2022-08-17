You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.
You start on square 1 of the board. In each move, starting from square curr, do the following:
Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
  
Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
Output: 4
  
class Solution {
    public int snakesAndLadders(int[][] board) {
        int count = 0;
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        boolean[] isV = new boolean[n*n+1];
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (isV[cur]) continue;
                isV[cur] = true;
                if (cur == n*n) return count;
                for (int j = 1; j <= 6; j++) {
                    if (cur+j<=n*n) {
                        if (getValue(board, cur+j) == -1 && !isV[cur+j]) {
                            q.offer(cur+j);
                        } else if (getValue(board, cur+j) > 0 && !isV[getValue(board, cur+j)]) {
                            q.offer(getValue(board, cur+j));
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
    public int getValue(int[][]board, int cur) {
        int n = board.length;
        int r = (cur-1)/n;
        int x = n - r - 1;
        int y = (r%2 == 0) ? cur-1-r*n : n - cur + r*n;
        return board[x][y];
    }
}
