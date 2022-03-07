You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
Return a list of integers representing the size of these parts.

Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
  
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] bucket = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i)-'a'] = i; //get the last position of every character; 
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            //把end设置成当前遇到的所有字符末置位最大的那个，这样只有当i遇到了end说明截至目前所有的都遇到了
            end = Math.max(i, bucket[s.charAt(i)-'a']);
            // if yes
            if (i == end) {
                res.add(end-start+1);
                start = i+1;
            }
        }
        return res;
    }
}
