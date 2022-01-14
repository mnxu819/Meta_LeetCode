Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
  
I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
  
Example 1:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
  
class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'X' || s.charAt(i) == 'V') {
                if (i > 0 && s.charAt(i-1) == 'I') {
                    res -= 2;
                }
            }
            if (s.charAt(i) == 'L' || s.charAt(i) == 'C') {
                if (i > 0 && s.charAt(i-1) == 'X') {
                    res -= 20;
                }
            }
            if (s.charAt(i) == 'D' || s.charAt(i) == 'M') {
                if (i > 0 && s.charAt(i-1) == 'C') {
                    res -= 200;
                }
            }
            res += map.get(s.substring(i, i+1));
        }
        return res;
    }
}
