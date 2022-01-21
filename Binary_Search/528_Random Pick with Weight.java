You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).
For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).

Example 1:
Input
["Solution","pickIndex"]
[[[1]],[]]
Output
[null,0]

Explanation
Solution solution = new Solution([1]);
solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element in w.

class Solution {
    private int[] prefixSums;
    Random random;
    public Solution(int[] w) {
        this.random = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i-1];
        }
        this.prefixSums = w;
    }
    
    public int pickIndex() {
        double target = random.nextInt(prefixSums[prefixSums.length-1])+1;
        int start = 0, end = this.prefixSums.length-1;
        while (start < end) {
            int mid = start + (end-start)/2;
            if (this.prefixSums[mid] == target) {
                return mid;
            } else if (this.prefixSums[mid] < target) {
                start = mid+1;
            } else 
                end = mid;
        }
        return start;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
