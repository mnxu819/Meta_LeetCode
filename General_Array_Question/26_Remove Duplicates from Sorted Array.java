Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. 
The relative order of the elements should be kept the same.
  
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        for (i = 1; i < nums.length && j < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }
}  
