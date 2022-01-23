Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
  
Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4
  
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;
        for (int pile : piles) {
            end = Math.max(end, pile);
        }
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (getHour(piles, mid) > h) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (getHour(piles, start) <= h) {
            return start;
        }
        return end;
    }
    public int getHour(int[] piles, int k) {
        int res = 0;
        for (int pile : piles) {
            if (pile % k == 0) {
                res += pile/k;
            } else {
                res += pile/k+1;
            }
        }
        return res;
    }
}
