An array is monotonic if it is either monotone increasing or monotone decreasing.
An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
Given an integer array nums, return true if the given array is monotonic, or false otherwise.

Example 1:
Input: nums = [1,2,2,3]
Output: true
  
class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2) return true;
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                isDecreasing = false;
            }
            if (nums[i] < nums[i-1]) {
                isIncreasing = false;
            }
        }
        return isDecreasing || isIncreasing;
    }
}
