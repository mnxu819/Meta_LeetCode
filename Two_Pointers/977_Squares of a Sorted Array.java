Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
  
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int right = n-1;
        for (int i = n-1; i >= 0; i--) {
            //-4, -2, -1, 0, 2, 3, 5分别从两边往中间走，把大的放到新数组里
            if (Math.abs(nums[right]) > Math.abs(nums[left])) {
                res[i] = Math.abs(nums[right--]);
            } else {
                res[i] = Math.abs(nums[left++]);
            }
            res[i] = res[i]*res[i];
        }
        return res;
    }
}
