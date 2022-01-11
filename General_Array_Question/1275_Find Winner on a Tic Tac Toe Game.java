Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

Players take turns placing characters into empty squares ' '.
The first player A always places 'X' characters, while the second player B always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never on filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
  
class Solution {
    int[][] board;
    int n = 3;
    public String tictactoe(int[][] moves) {
        board = new int[3][3]; 
        int steps = moves.length;
        int player = 1;
        for (int i = 0; i < steps; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
            board[row][col] = player;
            if (checkRow(row, player) ||
               checkCol(col, player) ||
               checkDiagnal(player) ||
               checkAntiDiagnal(player)) {
                return player == 1 ? "A" : "B";
            }
            player *= -1;
        }
        return moves.length == n*n ? "Draw" : "Pending";
    }
    public boolean checkRow(int row, int player) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] != player) return false;
        }
        return true;
    }
    public boolean checkCol(int col, int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][col] != player) return false;
        }
        return true;
    }
    public boolean checkDiagnal(int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][i] != player) return false;
        }
        return true;
    }
    public boolean checkAntiDiagnal(int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][n-1-i] != player) return false;
        }
        return true;
    }
}
