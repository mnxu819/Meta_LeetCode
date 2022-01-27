A peak element is an element that is strictly greater than its neighbors.
Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞.
You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
  
class Solution {
    public int findPeakElement(int[] nums) {
        //XXXOO类型题，xxx和ooo区别是x部分的前一个数比后一个数小，o部分前一个数比后一个数大
        int start = 0; 
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] > nums[mid-1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] > nums[end]) {
            return start;
        } else 
            return end;
    }
}
/***********************************************************************************************/

A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom. run in mlog(n)
列作为二分法，找到中间列，找到最大的row，比较【最大row】【中间列】和左右比，都大就是要找的，右边大，说明最大值在右边，左边+1，左边大说明最大值在左边，右边-1.  
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int startCol = 0;
        int endCol = mat[0].length-1;
        while (startCol <= endCol) {
            int midCol = startCol + (endCol - startCol)/2;
            //寻找midCol的最大值所在row
            int maxRow = 0;
            for (int i = 0; i < mat.length; i++) {
                maxRow = mat[i][midCol] >= mat[maxRow][midCol] ? i : maxRow;
            }
            boolean leftIsBig = midCol - 1 >= startCol && mat[maxRow][midCol-1] > mat[maxRow][midCol]; 
            boolean rightIsBig = midCol + 1 <= endCol && mat[maxRow][midCol+1] > mat[maxRow][midCol]; 
            if (!leftIsBig && !rightIsBig) {
                return new int[]{maxRow, midCol};
            } else if (rightIsBig) {
                startCol = midCol+1;
            } else {
                endCol = midCol-1;
            }
        }
        return null;
    }
}
