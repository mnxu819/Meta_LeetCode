Given the sorted rotated array nums of unique elements, return the minimum element of this array.
  
Example 1:
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
  
class Solution {
    public int findMin(int[] nums) {
        //XXXOO类型题，xxx和ooo区别是xxx部分永远比最右端数大
        int start = 0; 
        int end = nums.length-1;
        while (start + 1 < end){
            int mid = start + (end-start)/2;
            if (nums[mid]>nums[nums.length-1]) {
                start = mid;
            } else 
                end = mid;
        }
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}
