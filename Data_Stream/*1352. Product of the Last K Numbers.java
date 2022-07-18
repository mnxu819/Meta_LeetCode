Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.
  
class ProductOfNumbers {
    //Time O(1) each
    //Space O(N)
    //如果遇到0，从头算起，要在数组设置一个1，因为算prefixProduct，极限情况是算所有的乘积，要除以1
    List<Integer> A;
    public ProductOfNumbers() {
        A = new ArrayList<>();
        A.add(1);
    }
    
    public void add(int num) {
        if (num > 0) {
            A.add(A.get(A.size()-1)*num);
        } else {
            A = new ArrayList<>();
            A.add(1);
        }
    }
    
    public int getProduct(int k) {
        int n = A.size();
        return n > k ? A.get(n-1)/A.get(n-k-1) : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
