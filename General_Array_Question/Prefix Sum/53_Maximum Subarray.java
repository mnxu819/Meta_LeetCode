Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
A subarray is a contiguous part of an array.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
  
class Solution {
    public int maxSubArray(int[] nums) {
        int totalSum = 0;
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums){
            minSum = Math.min(minSum, totalSum);//当前之前的最小值，因为有可能当前的就是最小值，极端情况只有一个数5，如果minsum在totalsum之后，minsum是5，maxSum是就为0了。
            totalSum += num;
            maxSum = Math.max(maxSum, totalSum-minSum);
        }
        return maxSum;
    }
}
