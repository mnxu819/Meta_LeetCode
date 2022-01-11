Given a string num which represents an integer, return true if num is a strobogrammatic number.
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Example 1:
Input: num = "69"
Output: true
  
class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        int left = 0;
        int right = num.length()-1;
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('8', '8');
        map.put('1', '1');
        while (left <= right) {
           if (!map.containsKey(num.charAt(left)) ||
               map.get(num.charAt(left)) != num.charAt(right)) {
               return false;
           }
            left++;
            right--;
        }
        return true;
    }
}
