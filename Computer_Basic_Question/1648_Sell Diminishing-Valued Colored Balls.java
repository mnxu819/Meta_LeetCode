class Solution {
    public int maxProfit(int[] inventory, int orders) {
        //1 3 6 6 6 -> 1 3 5 5 5 -> 1 3 4 4 4 -> 1 3 3 3 3
        //1 3 3 3 3
        //1 1 1 1 1
        //0 0 0 0 0
        //思想就是先排序，然后把所有6减到3，计算之间的order数，如果小于orders直接算值，大于就算从开始逐行加
        int mod = 1000000007;//约等于10的9次方
        Arrays.sort(inventory);// O(NlogN)
        int currentIdx = inventory.length - 1;
        int currentNum =  inventory[currentIdx];
        long profit = 0;
        while (orders > 0) {
            // find the next number which is not equal to current number
            while (currentIdx >= 0 && inventory[currentIdx] == currentNum) {
               currentIdx--;
            }
            int nextNum = currentIdx >= 0 ?  inventory[currentIdx] :  0; //3
            int currentOrder = (currentNum-nextNum)* (inventory.length-1-currentIdx);// (6-3)*(4-1)
            if (currentOrder <= orders) {
                profit += (long)(currentNum+nextNum+1)*(currentNum-nextNum)/2*(inventory.length-1-currentIdx); // (4+5+6)*3
            } else {
                int currentRow = orders/(inventory.length-1-currentIdx);
                int currentCol = orders%(inventory.length-1-currentIdx);
                profit += (long)(currentNum+currentNum-currentRow+1)*currentRow/2*(inventory.length-1-currentIdx);
                profit += (long)(currentNum-currentRow)*currentCol;
            }
            orders -= currentOrder;
            profit %= mod;
            currentNum = nextNum;
        }
        return (int)profit;
    }
}
