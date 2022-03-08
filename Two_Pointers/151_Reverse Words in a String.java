Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
  
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
  
class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        // "eulb si yks eht"
        reverseString(chars, 0, chars.length-1);
        chars = removeSpace(chars, chars.length).toCharArray();
        // "blue is sky the"
        reverseWord(chars, chars.length);
        return new String(chars);
    }
    public void reverseString(char[] chars, int start, int end) {
        while (start <= end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }
     public String removeSpace(char[] chars, int n) {
        int index = 0;
        int i = 0;
         while (i < n) {
             while (i < n && chars[i] == ' ') i++;// clear pre space
             while (i < n && chars[i] != ' ') chars[index++] = chars[i++];//put non empty word to front
             while (i < n && chars[i] == ' ') i++;// clear after space
             if (i < n) chars[index++] = ' '; // add one space
         }
         return new String(chars).substring(0, index);
    }
     public void reverseWord(char[] chars, int n) {
         int index = 0;
         int i = 0;
         while (i < n) {
             while (i < n && chars[i] != ' ') i++;
             reverseString(chars, index,  i-1);
             i++;
             index = i;
         }
    }
}
