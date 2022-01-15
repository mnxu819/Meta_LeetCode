Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
After doing so, return the array.

Example 1:
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]

class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;  
        for (int i = arr.length-1; i >= 0; i--) {
            int curMax = max;
            max = Math.max(max, arr[i]);
            arr[i] = curMax;
        }
        return arr;
    }
}
