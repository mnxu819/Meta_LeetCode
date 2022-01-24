Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].
  
Input: n = 11
Output: 0
Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
  
class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int i = 1;
        while (n > len * count) {
            n -= len*count;
            len++;
            count *= 10;
            i *= 10;
        }
        
        i += (n-1)/len;
        String s = Integer.toString(i);
		return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
