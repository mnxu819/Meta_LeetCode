Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
  
Example 1:
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
  
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (1+nums.length)*nums.length/2 - sum;
    }
}
