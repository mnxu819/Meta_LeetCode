You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
Return the single element that appears only once.
Your solution must run in O(log n) time and O(1) space.

Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
  
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)  return nums[0];
        int start = 0;
        int end = (nums.length-2)/2;//两两分组下标,当组里的第一个不等于第二个说明在前面，等于说明在后面
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid*2] != nums[mid*2+1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start*2] != nums[start*2+1]) {
            return nums[start*2];
        } else if (nums[end*2] != nums[end*2+1]) {
            return nums[end*2];
        }
        return nums[nums.length-1];
    }
}
