There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
  
class Solution {
    public int search(int[] nums, int target) {
        //分两步找到最低端，判断是哪个折线上，然后二分
        int min = findMinimum(nums);
        if (min == 0) return binarySearch(nums, 0, nums.length-1, target);
        if (target > nums[nums.length-1]) {
            return binarySearch(nums, 0, min-1, target);
        } else 
            return binarySearch(nums, min, nums.length-1, target);
    }
    public int findMinimum(int[] nums) {
        int start = 0; 
        int end = nums.length-1;
        while (start + 1 < end){
            int mid = start + (end-start)/2;
            if (nums[mid]>nums[nums.length-1]) {
                start = mid;
            } else 
                end = mid;
        }
        return nums[start] < nums[end] ? start : end;
    }
    public int binarySearch(int[] nums, int start, int end, int target) {
        while (start + 1 < end){
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                return mid;            
            } else if (nums[mid] < target) {    
                start = mid;
            } else 
                end = mid;
            }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
