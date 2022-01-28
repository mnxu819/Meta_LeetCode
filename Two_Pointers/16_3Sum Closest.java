Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
  
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length-1;
            while (start < end) {
                if (Math.abs(nums[i]+nums[start]+nums[end]-target) < minDiff) {
                    minDiff = Math.abs(nums[i]+nums[start]+nums[end]-target);
                    res = nums[i]+nums[start]+nums[end];       
                } 
                if (nums[i]+nums[start]+nums[end] < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }
}
