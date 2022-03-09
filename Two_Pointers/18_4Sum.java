Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.
  
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-3; i++) {
            //找到第一个不同的元素
            if (i == 0 || i > 0 && nums[i] != nums[i-1]) {
                 for (int j = i+1; j < nums.length-2; j++) {
                    //找到第一个不同的元素
                    if (j == i+1 || j > i+1 && nums[j] != nums[j-1]) {
                        int newTarget = target-nums[i]-nums[j];
                        int a = j+1;
                        int b = nums.length-1;
                        while (a < b) {
                            if(newTarget == nums[a] + nums[b]) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[a], nums[b]));
                                while (a < b && nums[a] == nums[a+1]) a++;
                                while (b > a && nums[b] == nums[b-1]) b--;
                                a++;
                                b--;
                            } else if (newTarget < nums[a] + nums[b]) {
                                b--;
                            } else 
                                a++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
