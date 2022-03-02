The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
  
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }   
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}
/***************having a loop****************/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();// record the index
        for (int i = 2*nums.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i%nums.length]) {
                stack.pop();
            }
            res[i%nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }
}
/***************find smallest next greater number****************/
find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = (""+n).toCharArray();
        int i = nums.length-2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i<0) {
            return -1;
        } else {
            for (int j = nums.length-1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(i, j, nums);
                    reverse(i+1, nums);
                    break;
                }
            }
        }
        long val = Long.parseLong(new String(nums));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }
    public void swap(int i, int j, char[] nums) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    } 
    public void reverse(int i, char[] nums) {
        int start = i;
        int end = nums.length-1;
        while (start <= end){
            char tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
