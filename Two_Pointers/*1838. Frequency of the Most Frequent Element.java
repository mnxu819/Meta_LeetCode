The frequency of an element is the number of times it occurs in an array.
You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
Return the maximum possible frequency of an element after performing at most k operations.

Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.  
//O(N(logN))  

class Solution {
    public int maxFrequency(int[] nums, int k) {
        //Sort the input array A
        //Sliding window prolem actually,
        //the key is to find out the valid condition:
        //k + sum >= size * max
        Arrays.sort(nums);
        int j = 0;
        long sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum+k < (long) (i-j+1)*nums[i]) {
                sum -= nums[j];
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
