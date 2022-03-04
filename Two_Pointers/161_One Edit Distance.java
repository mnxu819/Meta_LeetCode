Given two strings S and T, determine if they are both one edit distance apart.
One ediit distance means doing one of these operation:

insert one character in any position of S
delete one character in S
change one character in S to other character

Input: s = "aDb", t = "adb" 
Output: true
  
public class Solution {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // write your code here
        int m = s.length()-1;
        int n = t.length()-1;
        if (m < n) return isOneEditDistance(t,s);
        if (m - n > 1 || s.equals(t)) return false;
        
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i+1).equals(m == n ? t.substring(i+1) : t.substring(i));
            }
        }
        return true;
    }
}
