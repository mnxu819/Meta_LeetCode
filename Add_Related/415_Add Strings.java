Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

Example 1:
Input: num1 = "456", num2 = "77"
Output: "533"
  
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int d1 = i >= 0 ? num1.charAt(i--)-'0' : 0;
            int d2 = j >= 0 ? num2.charAt(j--)-'0' : 0;
            int sum = d1 + d2 + carry;
            int digit = sum%10;
            carry = sum/10;
            sb.append(digit);
        }
        if (carry != 0) sb.append(1);
        return sb.reverse().toString();
    }
}
