You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.
A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.
Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

Example 1:

Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: ["2","4->49","51->74","76->99"]
Explanation: The ranges are:
[2,2] --> "2"
[4,49] --> "4->49"
[51,74] --> "51->74"
[76,99] --> "76->99"
  
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(formatRange(lower, upper));
            return res;
        }
        if (nums[0] > lower) {
            res.add(formatRange(lower, nums[0]-1));
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] != nums[i] + 1) {
                res.add(formatRange(nums[i]+1, nums[i+1]-1));
            }   
        }
        if (nums[nums.length-1] < upper) {
            res.add(formatRange(nums[nums.length-1]+1, upper));
        }
        return res;
    }
    private String formatRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        } 
        return lower+"->"+upper;
    }
}
