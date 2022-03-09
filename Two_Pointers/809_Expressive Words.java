Input: s = "heeellooo", words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
  
class Solution {
    public int expressiveWords(String s, String[] words) {
        if (s == null || words == null) return 0;
        int count = 0;
        for (String word: words) {
            if (isStretchy(word, s)) {
                count++;
            }
        }
        return count;
    }
    public boolean isStretchy(String word, String s) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) {
                int l1 = getLen(s, j);
                int l2 = getLen(word, i);
                //两种情况，个数小于3，两个不相等，或者个数大于等于3，word大于s个数
                if ((l1 < 3 && l1 != l2) || (l1>=3 && l1<l2)) {
                    return false;
                }
                //不是加1是加重复的个数
                i = i+l2;
                j = j+l1;
            } else {
                return false;
            }
        }
        return i == word.length() && j == s.length();
    }
    public int getLen(String s, int index) {
        int i = index;
        while (i < s.length() && s.charAt(i) == s.charAt(index)) {
            i++;
        }
        return i-index;
    }
}
