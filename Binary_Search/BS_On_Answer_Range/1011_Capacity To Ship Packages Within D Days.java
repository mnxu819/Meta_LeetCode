A conveyor belt has packages that must be shipped from one port to another within days days.
The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

Example 1:
Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10
Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
  
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;//start必须至少是最大的货物量
        int end = 0;//最大是所有的货物量
        for (int i = 0; i < weights.length; i++) {
            end += weights[i];
            start = Math.max(start, weights[i]);
        }
        while (start + 1 < end) {
            int mid = start + (end-start)/2;
            //>days说明太小了不足以满足days的要求，所以要变大
            if (getDays(mid, weights) > days) {
                start = mid;
            } else 
                end = mid;
        }
        if (getDays(start, weights) <= days) {
            return start;
        } else 
            return end;
    }
    public int getDays(int capacity, int[] weights) {
        int res = 0;
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight > capacity){
                //总数超过了capacity，sum设为当前的weight，天数要加1
                sum = weight;
                res++;
            } else 
                sum += weight;       
        }
        return res+1;//这个1是为了最后一天加的，最后天无论如何都不会超过capacity，但没有被算进去
    }
}
