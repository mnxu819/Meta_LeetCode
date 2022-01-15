You are given a sorted unique integer array nums.
Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
Each range [a,b] in the list should be output as:
"a->b" if a != b
"a" if a == b

Example 1:
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
  
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        for (int j = 1; j <nums.length; j++) {
            if (nums[j] == nums[j-1]+1){
                continue;
            }
            res.add(formatString(nums[i], nums[j-1]));
            i = j;
        }
        if (i <= nums.length-1) {
            res.add(formatString(nums[i], nums[nums.length-1]));
        }
        return res;
    }
    public String formatString(int a, int b) {
        if (b > a) {
            return a+"->"+b;
        } else if (a == b) {
            return String.valueOf(a);
        } else 
            return null;
    }
}
