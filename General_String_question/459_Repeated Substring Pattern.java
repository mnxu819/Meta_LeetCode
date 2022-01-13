Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
  
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null) return true;
        int len = s.length();
        for (int i = 1; i <= len/2; i++) {
            if (len%i == 0) {
                String pattern = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < len/i; j++){
                    sb.append(pattern);
                }
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
