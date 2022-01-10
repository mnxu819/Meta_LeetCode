Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
Find the kth positive integer that is missing from this array.
  
Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
  
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length-1;
        // arr[i]-(i+1) current missing total number
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (arr[mid]-(mid+1) < k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (arr[end]-(end+1) < k) {
            return end + k + 1;
        } else if (arr[start]-(start+1) >= k) {
            return start + k;
        }
            return start + k + 1;
    }
}
