The array-form of an integer num is an array representing its digits in left to right order.
For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.

Example 1:
Input: num = [2,1,5], k = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
  
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int i = num.length-1;
        int carry = 0;
        while (i >= 0 || k > 0) {
            int val1 = i >= 0 ? num[i--] : 0;
            int val2 = k > 0 ? k%10 : 0; 
            k /= 10;
            int sum = val1 + val2 + carry;
            res.add(0, sum%10);//arraylist先加的在前面
            carry = sum/10;
        }
        if (carry == 1) res.add(0, 1);
        return res;
    }
}
