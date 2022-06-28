You are standing at position 0 on an infinite number line. There is a destination at position target.
给1到k加符号使得和是target

class Solution {
    public int reachNumber(int target) {
        if (target < 0) return reachNumber(-target);
        int k = 0;
        // find first k that 1+...+k > target
        while (target > 0) {
            target -= ++k;
        }
        //如果是奇数，需要看k+1，1）k+1是奇数，则是k+1,
        //2）k+1是偶数， k+1加差还是奇数，所以是k+2，所以第二种情况，只要看k是否是奇数
        return target%2 == 0 ? k : (k+1) + k%2;
    }
}
