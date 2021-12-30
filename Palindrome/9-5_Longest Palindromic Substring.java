package Palindrome;
/*
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/
//O(N) time O(1) space
class Solution {
    public String longestPalindrome(String s) {
        int maxLen = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = longestPalindromeLen(s, i, i);
            int b = longestPalindromeLen(s, i, i+1);
            int max = Math.max(a, b);
            if (max > maxLen) {
                maxLen = max;
                if (maxLen == a) {
                    start = i - maxLen/2;
                    end = i + maxLen/2;
                } else {
                    start = i - maxLen/2 + 1;
                    end = i + maxLen/2;
                }
            }
        }
        return s.substring(start, end+1);
    }
    public int longestPalindromeLen(String s, int i, int j) {
        int start = i;
        int end = j;
        int len = 0;
        while (start >= 0 && end <= s.length()-1) {
            if (s.charAt(start--) != s.charAt(end++)) {
                break;
            }
            len = len + 2;
        }
        return i == j ? len - 1 : len;
    } 
}