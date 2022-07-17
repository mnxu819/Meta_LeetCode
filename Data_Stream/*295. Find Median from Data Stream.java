The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.

class MedianFinder {
    // O(log n) add, O(1) find
    //The length of smaller half is kept to be n / 2 at all time and the length of the larger half is either n / 2 or n / 2 + 1
    public Queue<Integer> minPQ = new PriorityQueue<>(new Comparator<Integer>(){
        public int compare(Integer o1, Integer o2){
            return o2-o1;
        }
    });
    public Queue<Integer> PQ = new PriorityQueue<>();

    public MedianFinder() {

    }
    
    public void addNum(int num) {
        PQ.add(num);
        minPQ.offer(PQ.poll());
        if (PQ.size()<minPQ.size()) {
            PQ.offer(minPQ.poll());
        }
    }
    
    public double findMedian() {
        return PQ.size() > minPQ.size() ? PQ.peek() : (PQ.peek()+minPQ.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
