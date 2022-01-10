You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
  
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int count = 0;//fill in all the possible bed and check if count is larger than n
        while (i < flowerbed.length) {
            //条件是该位置必须是0，如果是第一个或者最后一个，其左右两边必须是0
            if (flowerbed[i] == 0 && 
                (i == 0 || flowerbed[i-1] == 0) &&
                (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }
}
