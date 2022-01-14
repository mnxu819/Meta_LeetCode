Given an array of integers arr, replace each element with its rank.
The rank represents how large the element is. The rank has the following rules:
Rank is an integer starting from 1.
The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
Rank should be as small as possible.

Example 1:
Input: arr = [40,10,20,30]
Output: [4,1,2,3]
Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
  
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortList = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortList);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i = 1; i <= sortList.length; i++) {
            if (!map.containsKey(sortList[i-1])) {
                map.put(sortList[i-1], rank++);
            } 
        }
         for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
