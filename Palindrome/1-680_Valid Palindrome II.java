/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:
Input: s = "aba"
Output: true

Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:
Input: s = "abc"
Output: false
 
Constraints:
1 <= s.length <= 105
s consists of lowercase English letters.
*/
//写一个函数remove掉一个字符是否还是回文，在主函数上当有一对字符不相等时，看一下移除任意一个是否时回文串，否就是false
//O(N) time O(1) space
class Solution {
    public boolean validPalindrome(String s) {
        int start = 0; 
        int end = s.length()-1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start) || isPalindrome(s, end);
            }
            start++;
            end--;
        }
        return true;
    }
    // write a function to check if remove one character, the string is still palindrome.
    public boolean isPalindrome(String s, int index) {
        int start = 0; 
        int end = s.length()-1;
        while (start <= end) {
            if (start == index){
                start = start+1;
            } else if (end == index) {
                end = end-1;
            }
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
