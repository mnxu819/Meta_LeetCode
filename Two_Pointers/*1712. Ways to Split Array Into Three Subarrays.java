A split of an integer array is good if:
The array is split into three non-empty contiguous subarrays - named left, mid, right respectively from left to right.
The sum of the elements in left is less than or equal to the sum of the elements in mid, and the sum of the elements 
in mid is less than or equal to the sum of the elements in right.
  
Input: nums = [1,2,2,2,5,0]
Output: 3
Explanation: There are three good ways of splitting nums:
[1] [2] [2,2,5,0]
[1] [2,2] [2,5,0]
[1,2] [2,2] [5,0]

class Solution {
    public int waysToSplit(int[] nums) {
        int[] A = new int[nums.length];
        A[0] = nums[0];
        int mod = (int) (1e9+7);
        int count = 0;
        //建立preSum数组
        for (int i = 1; i < nums.length; i++) {
            A[i] = A[i-1] + nums[i];
        }
       //二分法找出不大于和不小于满足的index，然后取其区间即为满足条件的个数
        for (int i = 1; i < nums.length-1; i++) {
            if (A[i-1] > (A[A.length-1]-A[i-1])/2) break;
            int left = bs(A, A[i-1], i, true);
            int right = bs(A, A[i-1], i, false);
            if (left == -1 || right == -1) continue;
            count = (count + (right-left+1)%mod)%mod;
        }
        return count;
    }
    public int bs(int[] A, int leftSum, int leftIndex, boolean isLeftSearch) {
        int start = leftIndex;
        int end = A.length-2;
        int res = -1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            int midSum = A[mid]-A[leftIndex-1];
            int rightSum = A[A.length-1]-A[mid];
            if (leftSum <= midSum && midSum <= rightSum) {
                res = mid;
                if (isLeftSearch) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else if (leftSum > midSum) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return res;
    }
}
