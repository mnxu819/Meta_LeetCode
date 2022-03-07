You are given an array of integers nums and an integer target.
Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.
Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: There are 4 subsequences that satisfy the condition.
[3] -> Min value + max value <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
[3,5,6] -> (3 + 6 <= 9)
[3,6] -> (3 + 6 <= 9)

  
  class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        int mod = (int)1e9+7;
        int[] pow = new int[nums.length];
        pow[0] = 1;
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            pow[i] = pow[i-1]*2%mod;
        }
        while(start <= end) {
            if (nums[start]+nums[end] > target) {
                end--;
            } else {
                res = (res+pow[end-start])%mod;
                start++;
            }
        }
        return res;
    }
}
