Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.
You must find a solution with a memory complexity better than O(n2).

Example 1:
Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
  
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length-1;
        int start = matrix[0][0];
        int end = matrix[m][m];
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            int count =  countLessEqual(matrix, mid);
            if (count < k) {
                start = mid;
            } else 
                end = mid;
        }
        if (countLessEqual(matrix, start) >= k)
            return start;
        return end;
    }
    public int countLessEqual(int[][] matrix, int value) {
        int count = 0;
        int i = 0, j = matrix.length-1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] <= value) {
                count += j+1;//把该行自j左面的所有个数加上
                i++;
            } else 
                j--;
        }
        return count;
    }
}
