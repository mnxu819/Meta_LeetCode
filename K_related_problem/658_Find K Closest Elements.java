Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 
Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int index = getClosestIndex(arr, x);
        int left = index-1;
        int right = index;
        for (int i = 0; i < k; i++) {
            if (left < 0) {
                res.add(arr[right++]);
            } else if (right >= arr.length) {
                res.add(arr[left--]);
            } else {
                if (x-arr[left] <= arr[right]-x) {
                    res.add(arr[left--]);
                } else {
                    res.add(arr[right++]);
                }
            }    
        }
        Collections.sort(res);
        return res;
    }
    public int getClosestIndex(int[] arr, int x) {
        int start = 0;
        int end = arr.length-1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                end = mid;
            } else 
                start = mid;
        }
        if (arr[start]-x > 0) {
            return start;
        } else 
            return end;
    }
}
