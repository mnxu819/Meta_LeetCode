Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.
Return the length of the shortest subarray to remove.
A subarray is a contiguous subsequence of the array.
  
Input: arr = [1,2,3,10,4,2,3,5]
Output: 3
Explanation: The shortest subarray we can remove is [10,4,2] of length 3. The remaining elements after that will be [1,2,3,3,5] which are sorted.
Another correct solution is to remove the subarray [3,10,4].
//从两边找到单调递增的数列，记录下标left和right，res在length-left和right之间，但有种情况就是两个单调数列有衔接的情况，
//需要两个数列从i=0,j=right开始扫描如果arr[i]<= arr[j]，比如[1,2,3,10,4,2,3,5]的第一个1，可以继续加在2,3,5之后，这样要check res和j-i-1，否则只要单纯j++为了结束循环

  class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        //1,2,3,10,4,2,3,5
        int left = 0;
        while (left < arr.length - 1 && arr[left] <= arr[left+1]) left++;//1,2,3,10, left = 3
        if (left == arr.length - 1) return 0;
        int right = arr.length-1;
        while(right > left && arr[right] >= arr[right-1]) right--;//2,3,5, right = 5
        int res = Math.min(arr.length-left-1, right);//没有合并的情况，就是取左边的连续递增还是右边的连续递增
        int i = 0;
        int j = right;
        //比较两端递增数列的值，比如1小于右边的2，答案可以继续缩减
        while (i <= left && j < arr.length) {
            if (arr[i] <= arr[j]){
                res = Math.min(res, j-i-1);
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}
