Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2
  
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //用这种方法要分三种情况，因为总会得到连续的start和end，要考虑target在区间里区间外三种情况
        if (nums[start] >= target) {
            return start;
        } else if (nums[end] >= target) {
            return end;
        } else
            return end+1;
    }
}
