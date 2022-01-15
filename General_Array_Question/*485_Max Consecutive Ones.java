Given a binary array nums, return the maximum number of consecutive 1's in the array.
Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
  
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curCount = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                curCount++;
            } else {
                maxCount = Math.max(maxCount, curCount);
                curCount = 0;;
            }
        }
        return curCount > maxCount ? curCount : maxCount;//这里要处理最大的时候是最后的连续的1， 110011111
    }
}
