You are given two integer arrays of equal length target and arr. In one step, you can select any non-empty sub-array of arr and reverse it. You are allowed to make any number of steps.
Return true if you can make arr equal to target or false otherwise.

Input: target = [1,2,3,4], arr = [2,4,1,3]
Output: true
Explanation: You can follow the next steps to convert arr to target:
1- Reverse sub-array [2,4,1], arr becomes [1,4,2,3]
2- Reverse sub-array [4,2], arr becomes [1,2,4,3]
3- Reverse sub-array [4,3], arr becomes [1,2,3,4]
There are multiple ways to convert arr to target, this is not the only way to do so.  
  
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], map.getOrDefault(target[i], 0)+1);
            map.put(arr[i], map.getOrDefault(arr[i], 0)-1);
        }
        for (int num : map.keySet()) {
            if (map.get(num) != 0) {
                return false;
            }
        }
        return true;
    }
}
