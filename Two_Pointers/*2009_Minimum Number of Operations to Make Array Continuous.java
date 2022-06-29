You are given an integer array nums. In one operation, you can replace any element in nums with any integer.

nums is considered continuous if both of the following conditions are fulfilled:

All elements in nums are unique.
The difference between the maximum element and the minimum element in nums equals nums.length - 1.
For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.

Return the minimum number of operations to make nums continuous.
Input: nums = [1,10,100,1000]
Output: 3
Explanation: One possible solution is to:
- Change the second element to 2.
- Change the third element to 3.
- Change the fourth element to 4.
The resulting array is [1,2,3,4], which is continuous.
  
class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);//O(NlogN)
        int n = nums.length;
        int maxLen = 0;
        //第一步是排序去重，因为重复的是肯定要替换的，所以先不考虑重复的
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
          if (nums[i] != nums[i-1]) { 
            nums[index++] = nums[i];
          }
        }
        //先排序，然后对每个i，搜索nums[i], nums[i]+n这个区间，有多少元素，取最大的
        for (int i = 0, j = 0; i < index; i++) {
            while (j < index && nums[j]-nums[i] <= n-1) {
                j++;
            }
            maxLen = Math.max(j-i, maxLen);
        }
        return n-maxLen;
    }
}
