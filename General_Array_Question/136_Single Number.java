Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1
  
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            if (set.contains(num)){
                sum -= num;
                set.remove(num);
            } else {
                sum += num;
                set.add(num);
            }
        }
        return sum;
    }
}
