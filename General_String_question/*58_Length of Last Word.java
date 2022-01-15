Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.

Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
  
class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            while (s.charAt(i) == ' ') {
                i--;
            }
            while (i >= 0 && s.charAt(i) != ' '){
                len++;
                i--;
            }
            if (i >= 0 && s.charAt(i) == ' ') {
                break;
            }
        }
        return len;
    }
}
