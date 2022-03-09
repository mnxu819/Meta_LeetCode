Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
  
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (isPermutation(s1, s2.substring(i, i+s1.length()))) {
                return true;
            }
        }
        return false;
    }
    public boolean isPermutation(String s1, String s2) {
        int[] bucket = new int[26];
        for (char c : s1.toCharArray()) {
            bucket[c-'a']++;
        }
        for (char c : s2.toCharArray()) {
            bucket[c-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (bucket[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
