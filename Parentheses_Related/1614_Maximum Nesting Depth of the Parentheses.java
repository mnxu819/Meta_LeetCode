A string is a valid parentheses string (denoted VPS) if it meets one of the following:

It is an empty string "", or a single character not equal to "(" or ")",
It can be written as AB (A concatenated with B), where A and B are VPS's, or
It can be written as (A), where A is a VPS.
  
Example 1:
Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3
Explanation: Digit 8 is inside of 3 nested parentheses in the string.
  
class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int cur = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
               maxDepth = Math.max(maxDepth, ++cur);
            } else if (c == ')') {
                cur--;
            }
        }
        return maxDepth;
    }
}
