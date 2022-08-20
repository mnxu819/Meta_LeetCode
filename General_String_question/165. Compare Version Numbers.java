Given two version numbers, version1 and version2, compare them.
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".

以.为分组， 1,01， 1,001比较每一个数

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++) {
            Integer digit1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            Integer digit2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            int res = digit1.compareTo(digit2);
            if (res != 0) return res;
        }
        return 0;
    }
}
