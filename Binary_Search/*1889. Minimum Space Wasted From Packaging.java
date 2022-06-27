Example 1:
Input: packages = [2,3,5], boxes = [[4,8],[2,8]]
Output: 6
Explanation: It is optimal to choose the first supplier, using two size-4 boxes and one size-8 box.
The total waste is (4-2) + (4-3) + (8-5) = 6.
//这道题思路先排序A和B，对于每个box遍历package，找到最后一个不大于box的package，那此时的值就是（i-j）*box的值
// 4 -> [2, 3, 5] index is 1，(1--1)*4
// 8 -> [2, 3, 5] index is 2, (2-1)*8
  class Solution {
     public int minWastedSpace(int[] A, int[][] boxes) {
        Arrays.sort(A);
        long res = Long.MAX_VALUE;
        long mod = (long)1e9 + 7, sumA = 0;
        for (int a : A) sumA += a;

        for (int[] B : boxes) {
            Arrays.sort(B);
            if (B[B.length - 1] < A[A.length - 1]) continue;
            long cur = 0, i = 0, j = -1;
            for (int b : B) {
                i = binarySearch(A, b);
                cur += b * (i - j);
                j = i;
            }
            res = Math.min(res, cur);
        }
        return res == Long.MAX_VALUE ? -1 : (int)((res - sumA) % mod);
    }
    // find the last element which is smaller than box
    private int binarySearch(int[] A, int box) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end-start)/2;
            if (A[mid] > box)
                end = mid;
            else
                start = mid;
        }
        if (A[end] <= box) {
            return end;
        } else if (A[start] <= box) {
            return start;
        } else 
            return -1;
    }
}
