Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
For example, if the price of a stock over the next 7 days were [100,80,60,70,60,75,85], then the stock spans would be [1,1,1,2,1,4,6].
  
 class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    //这道题思路是用一个栈存一个数组，一个当前值，一个截止当前连续的不大于当前值的个数
    //所以下一个数的max值即为，假设前几个数均小于下一个数，个数为前几个数的个数和+1
    public int next(int price) {
        int max = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            max += stack.peek()[1];
            stack.pop();
        }
        stack.add(new int[]{price, max});
        return max;
    }
}
