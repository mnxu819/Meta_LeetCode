Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO 
(First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
  
class MyCircularQueue {
    int[] arr;
    int front = 0;
    // when return Rear(), make sure rear is always k-1, so has to make Rear = -1;
    // 假设k=2，一次enqueue， rear变成0， 两次变成1，第三次就return false了，如果是0，rear两次变成2了
    int rear = -1;
    int len = 0;
    public MyCircularQueue(int k) {
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {
        if (!isFull()) {
            rear = (rear+1)% arr.length;
            arr[rear] = value;
            len++;
            return true;
        } else 
            return false;
    }
    
    public boolean deQueue() {
        // dequeue就是把front移动一位，前面的虽然有值但可以被rear重新赋值
        if (!isEmpty()) {
            front = (front + 1)%arr.length;
            len--;
            return true;
        } else 
            return false;
    }
    
    public int Front() {
        return isEmpty() ? -1 : arr[front];
    }
    
    public int Rear() {
         return isEmpty() ? -1 : arr[rear];
    }
    
    public boolean isEmpty() {
        return len == 0;
    }
    
    public boolean isFull() {
        return len == arr.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
