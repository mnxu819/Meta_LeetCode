In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.

Example 1:
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
O(M+N), O(M)  
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            int index = 0;
            while (index < words[i-1].length() && index < words[i].length()) {
                if (words[i-1].charAt(index) != words[i].charAt(index)) {
                   if (map.get(words[i-1].charAt(index)) > map.get(words[i].charAt(index))){
                       return false;
                   } else {
                       break;
                   }
                }
                index++;
            }         
            if (index == Math.min(words[i].length(), words[i-1].length())) {
                // app and apple
                if (words[i].length() < words[i-1].length()) return false;
            }
        }
        return true;
    }
}
