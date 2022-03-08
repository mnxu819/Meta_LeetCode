Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
  
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

class Solution {
    public void sortColors(int[] nums) {
        int i = 0; 
        int start = 0;
        int end = nums.length-1;
        // 202110-> 002112 -> 001122
        //三个指针，start和end分别代表放置0和2的index，i是移动指针，终止条件是i和end相遇
        while (i <= end) {
            //是0，交换i和start，两个指针都移动
            if (nums[i] == 0) {
                swap(nums, start, i);
                start++;
                i++;
                //是1,i移动
            } else if (nums[i] == 1) {
                i++;
                //是2，交换end和i，但注意i不能移动因为交换过来的在i位置的有可能是0或者1要重新再走一遍循环
            } else if (nums[i] == 2) {
                swap(nums, i, end);
                end--;
            }
        } 
        
    }
    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
