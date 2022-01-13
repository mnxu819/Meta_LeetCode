Given a positive integer num, write a function which returns True if num is a perfect square else False.
Follow up: Do not use any built-in library function such as sqrt.

Example 1:
Input: num = 16
Output: true
  
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 2) {
            return true;
        }
        long start = 2; 
        long end = num/2;
        while (start + 1 < end) {
            long mid = start + (end - start)/2;
            if (mid*mid == num) {
                return true;
            } else if (mid*mid < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start*start == num || end*end == num ? true : false;
    }
}
