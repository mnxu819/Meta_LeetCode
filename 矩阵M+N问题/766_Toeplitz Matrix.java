Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
  
Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: true
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
  
  
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                /*
                //It turns out two coordinates are on the same diagonal if and only if r1 - c1 == r2 - c2.
                if (!map.containsKey(j-i)){
                    map.put(j-i, matrix[i][j]);//record the difference and the destined value
                } else {
                    if (map.get(j-i) != matrix[i][j]) {
                        return false;
                    }
                }
                */
                if (i > 0 && j > 0 && matrix[i-1][j-1] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
