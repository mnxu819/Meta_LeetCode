Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
//三步翻转，1234|567-> 4321|567 -> 4321|765 -> 5671234
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        reverse(nums, 0, n-k%n-1);
        reverse(nums, n-k%n, n-1);
        reverse(nums, 0, n-1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
        return;
    }
}
