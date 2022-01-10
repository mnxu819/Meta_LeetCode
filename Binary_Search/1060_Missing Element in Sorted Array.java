Given an integer array nums which is sorted in ascending order and all of its elements are unique and given also an integer k, return the kth missing number starting from the leftmost number of the array.

Example 1:
Input: nums = [1,2,4], k = 3
Output: 6
Explanation: The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
  
class Solution {
    public int missingElement(int[] nums, int k) {
       //missing number quation: total missing number is nums[i]-nums[0]-i
        int start = 0;
        int end = nums.length-1;
        if (k > getMissingNumber(nums, end)){
            return nums[end]+k-getMissingNumber(nums, end);
        }
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (getMissingNumber(nums, mid) < k) {
                start = mid;
            } else 
                end = mid;
        }   
        return nums[end-1]+k-getMissingNumber(nums, end-1);
    }
    public int getMissingNumber(int[] nums, int index) {
        return nums[index] - nums[0] - index;
    }
}
