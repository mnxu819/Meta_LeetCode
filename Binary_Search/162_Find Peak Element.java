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
