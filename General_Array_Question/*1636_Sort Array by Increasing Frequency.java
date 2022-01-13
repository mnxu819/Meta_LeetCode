Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
Return the sorted array.

Example 1:
Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
  
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums.length];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        //entryset比map可以直接getValue和getKey
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> a.getValue() == b.getValue() ? b.getKey()-a.getKey() : a.getValue() - b.getValue());
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getValue(); j++) {
                res[index++] = list.get(i).getKey();
            }
        }
        return res;
    }
}
