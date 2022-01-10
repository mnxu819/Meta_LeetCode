Given two binary strings a and b, return their sum as a binary string.

Example 1:
Input: a = "11", b = "1"
Output: "100"
  
Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
  
class Solution {
    public String addBinary(String a, String b) {
        int m = a.length()-1;
        int n = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (m>=0 || n>=0) {
            int x = m >= 0 ? a.charAt(m) - '0' : 0;
            int y = n >= 0 ? b.charAt(n) - '0' : 0;
            int sum = (x+y+carry)%2;
            carry = (x+y+carry)/2;
            sb.append(sum);
            m--;
            n--;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
