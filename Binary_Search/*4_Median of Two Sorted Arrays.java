Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
  
  class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        //nums1[m1-1], nums1[m1]
        //nums2[m2-1], nums2[m2]
        //此题的思路是根据中位数的位置k，在数组1里找m1个数，在数组2找(m2 = k-m1)个数
        //中位数只能处在nums1[m1-1], nums2[m2-1], nums1[m1], nums2[m2]
        //需要找到第一个nums1[m1]大于nums2[m2-1]，因为如果nums1[m1]>nums2[m2-1],则说明（nums1[m1], nums2[m2]）均大于（nums1[m1-1], nums2[m2-1]）
        int k = (m + n + 1)/2;
        int start = 0;
        int end = m;
        int m1 = 0;
        int m2 = 0;
        while (start + 1 < end) {
            m1 = start + (end-start)/2;
            m2 = k - m1;
            if (nums1[m1] < nums2[m2-1]) {
                start = m1;
            } else {
                end = m1;
            }
        }
        // m > 0是防止nums1是空的
        if (m > 0 && nums1[start] >= nums2[k-start-1]) {
            m1 = start;
            m2 = k - start;
        } else {
            m1 = end;
            m2 = k - end;
        }
        int c1 = Math.max(m1 == 0 ? Integer.MIN_VALUE : nums1[m1-1], 
                          m2 == 0 ? Integer.MIN_VALUE : nums2[m2-1]);
        if ((m+n)%2 == 1) return c1;
        
        int c2 = Math.min(m1 == m ? Integer.MAX_VALUE : nums1[m1], 
                          m2 == n ? Integer.MAX_VALUE : nums2[m2]);
        return (double) (c1+c2)*0.5;
    }
}
