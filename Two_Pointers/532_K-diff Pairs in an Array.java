Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
nums[i] - nums[j] == k

Input: nums = [1,3,1,5,4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
  
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        //遍历Map可以不用重置
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
               if (entry.getValue() > 1) res++;
            } else {
                if (map.containsKey(entry.getKey()+k)) {
                    res++;
                }
            }
        }
        return res;
    }
}
