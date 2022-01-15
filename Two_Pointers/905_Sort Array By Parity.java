Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
Return any array that satisfies this condition.

Example 1:
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
  
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while (i <= j) {
            while (i <= j && nums[i]%2 == 0) {
                i++;
            }
            while (i <= j && nums[j]%2 != 0) {
                j--;
            }
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        return nums;
    }
}
