package Palindrome;
/*
Given a string s, return true if a permutation of the string could form a palindrome.

Example 1:
Input: s = "code"
Output: false

Example 2:
Input: s = "aab"
Output: true

Example 3:
Input: s = "carerac"
Output: true
 
Constraints:
1 <= s.length <= 5000
s consists of only lowercase English letters.
*/
//O(N) time O(1) space
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] b = new int[128];
        for (char c : s.toCharArray()) {
            b[c-'a']++;
        }
        int oddCount = 0; 
        for (int i = 0; i < 26; i++) {
            if (b[i] % 2 != 0) {
                oddCount++;
                if (oddCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}