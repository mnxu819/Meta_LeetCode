Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

Example 1:
Input: s = "hello"
Output: "holle"
  
class Solution {
    public String reverseVowels(String s) {
        String vowel = "aeiouAEIOU";
        Set<Character> set = new HashSet<>();
        for (char c : vowel.toCharArray()) {
            set.add(c);
        }
        int start = 0;
        int end = s.length()-1;
        char[] chars = s.toCharArray();
        while (start < end) {
            while (start < end && !set.contains(chars[start])) {
                start++;
            }
            while (start < end && !set.contains(chars[end])) {
                end--;
            }
            if (start < end) {
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end]= tmp;
                start++;
                end--;
            }
        }
        return String.valueOf(chars);
    }
}
