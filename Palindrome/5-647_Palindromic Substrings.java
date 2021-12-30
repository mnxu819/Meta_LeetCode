package Palindrome;
/*
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
*/
/*Time Complexity: O(N^2) for input string of length N. The total time taken in this approach is dictated by two variables:
The number of possible palindromic centers we process.
How much time we spend processing each center.

The number of possible palindromic centers is 2N-1: there are NN single character centers and N-1 consecutive character pairs as centers.
Each center can potentially expand to the length of the string, so time spent on each center is linear on average. Thus total time spent is N \cdot (2N-1) \simeq N^2N⋅(2N−1)≃N 2.

Space Complexity: O(1). We don't need to allocate any extra space since we are repeatedly iterating on the input string itself.
*/
class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += helper(s, i, i);
            res += helper(s, i, i+1); 
        }
        return res;
    }
    public int helper(String s, int i, int j) {
        int res = 0;
        int start = i;
        int end = j;
        while (start >= 0 && end <= s.length()-1) {
            if (s.charAt(start) != s.charAt(end)){
                break;
            }
            start--;
            end++;
            res++;
        }
        return res;
    }
}