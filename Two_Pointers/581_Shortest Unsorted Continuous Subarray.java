Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
Return the shortest such subarray and output its length.

Example 1:
Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
  
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;
        //从左往右找的是最后一个小于最大值的index
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max =nums[i];
            } else {
                end = i;
            }
        }
        //从右往左找的是第一个大于最小值的index
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] <= min) {
               min = nums[i];
            } else {
                start = i;
            }
        }
        return (start >= 0 && end >= 0) ? end-start+1 : 0;
    }
}
