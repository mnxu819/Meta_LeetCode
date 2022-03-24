Design your implementation of the circular double-ended queue (deque).
Implement the MyCircularDeque class:

class MyCircularDeque {
    int[] arr;
    int front = 0;
    int rear = -1;
    int len = 0;

    public MyCircularDeque(int k) {
        arr = new int[k];
    }
    
    public boolean insertFront(int value) {
        if (!isFull()) {
            front = (front-1)%arr.length;
            if (front < 0) {
                front += arr.length;
            }
            arr[front] = value;
            len++;
             //  Corner case： add Front -> get Rear
            //  This kind of case which can be handled in: Add rear -> get front
            //  In which rear has a initial of -1
            if(len == 1){
                rear = front;
            }
            return true;
        }
        return false;
        
    }
    
    public boolean insertLast(int value) {
        if (!isFull()) {
            rear = (rear+1)%arr.length;
            arr[rear] = value;
            len++;
            return true;
        } else 
            return false;
    }
    
    public boolean deleteFront() {
        if (!isEmpty()) {
            front = (front+1)%arr.length;
            len--;
            return true;
        } else 
            return false;
    }
    
    public boolean deleteLast() {
        if (!isEmpty()) {
            rear = (rear-1)%arr.length;
            if (rear < 0) {
                rear += arr.length;
            }
            len--;
            return true;
        } else 
            return false;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : arr[front];
    }
    
    public int getRear() {
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
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
