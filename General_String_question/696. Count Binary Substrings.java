Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
Substrings that occur multiple times are counted the number of times they occur.
  
Input: s = "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
  
class Solution {
    public int countBinarySubstrings(String s) {
        //group 00110001111 to 2, 2, 3, 4 pre和cur记录相邻的连续的0和1，取最小的和即为答案
        if (s == null || s.length() == 0) return 0;
        int pre = 0;
        int cur = 1;
        int res = 0;
        for (int j = 1; j < s.length(); j++) {
            if (s.charAt(j) == s.charAt(j-1)) {
                cur++;
            } else {
                res += Math.min(cur, pre);
                pre = cur;
                cur = 1;
            }
        }
        return res+Math.min(cur, pre);
    }
}
