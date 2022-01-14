Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /*
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
        */
        //把数组里的（数字-1）所得到的index里的值变为负数，正数的index就是缺的数字-1
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;//这一步是防止后面的数字被前面的操作已经变成负数了
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }
}
