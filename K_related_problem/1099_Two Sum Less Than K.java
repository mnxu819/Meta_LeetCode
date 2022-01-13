Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.

Example 1:
Input: nums = [34,23,1,24,75,33,54,8], k = 60
Output: 58
Explanation: We can use 34 and 24 to sum 58 which is less than 60.
  
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        int min = -1;
        while (start < end) {
            if (nums[start]+nums[end] < k) {          
                min = Math.max(min, nums[start]+nums[end]);
                start++;
            } else {
                end--;
            }
        }
        return min;
    }
}
