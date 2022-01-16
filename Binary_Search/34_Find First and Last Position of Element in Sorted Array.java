Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) return res;
        res[0] = getElement(nums, target, false);
        res[1] = getElement(nums, target, true);
        return res;
    }
    public int getElement(int[] nums, int target, boolean findLast) {
        int start = 0;
        int end = nums.length-1;
        while (start + 1 < end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                if (findLast) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else if (nums[mid] < target) {
                start = mid;
            } else 
                end = mid;
        }
        if (findLast) {
            if (nums[end] == target) {
                return end;
            } else if (nums[start] == target){
                return start;
            }
        } else {
            if (nums[start] == target){
                return start;
            } else if (nums[end] == target) {
                return end;
            }
        }
        return -1;
    }
}
