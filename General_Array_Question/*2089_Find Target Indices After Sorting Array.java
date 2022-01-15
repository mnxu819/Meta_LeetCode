You are given a 0-indexed integer array nums and a target element target.
A target index is an index i such that nums[i] == target.
Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.

Example 1:
Input: nums = [1,2,5,2,3], target = 2
Output: [1,2]
Explanation: After sorting, nums is [1,2,2,3,5].
The indices where nums[i] == 2 are 1 and 2.
  
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        //本题不能先排序，那就定义两个变量，一个是等于target的个数，一个是小于target的个数
        int equalT = 0;
        int lessThanT = 0;
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (num == target) equalT++;
            if (num < target) lessThanT++;
        }
        for (int i = 0; i < equalT; i++) {
            res.add(lessThanT+i);
        }
        return res;
    }
} 
