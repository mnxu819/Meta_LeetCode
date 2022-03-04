Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            //首个不和前一个相同的数字
            if (i == 0 || (i < nums.length && nums[i] != nums[i-1])) {
                int target = -nums[i];
                int j = i+1;
                int k = nums.length-1;
                while (j < k) {
                    if (nums[j]+nums[k] == target){
                        List<Integer> tmp = new ArrayList<>();
                        //清掉所有相同的找最后一个
                        while (j < k && nums[j+1] == nums[j]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k-1]) {
                            k--;
                        }
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                    } else if (nums[j]+nums[k] < target) {
                        j++;
                    } else 
                        k--;
                }
            }
        }
        return res;
    }
}
