You are given an array of strings words and a string chars.
A string is good if it can be formed by characters from chars (each character can only be used once).
Return the sum of lengths of all good strings in words.

Example 1:
Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
  
class Solution {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        for (String word : words) {
            if (isGoodWord(word, chars)) {
                res += word.length();
            }
        }
        return res;
    }
    public boolean isGoodWord(String word, String chars) {
        int[] bucket = new int[26];
        for (char c : chars.toCharArray()) {
            bucket[c-'a']++;
        }
        for (char c : word.toCharArray()) {
            bucket[c-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (bucket[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
