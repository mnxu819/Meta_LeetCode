You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
  
Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
  
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m-1;
        int len2 = n-1;
        for (int i = m+n-1; i>=0; i--) {
            if (len2 < 0) break;
            if (len1 >= 0 && nums1[len1] >= nums2[len2]) {
                nums1[i] = nums1[len1--];
            } else {
                nums1[i] = nums2[len2--];
            }
        }
    }
}
