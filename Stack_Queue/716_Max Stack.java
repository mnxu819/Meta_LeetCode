Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.

Implement the MaxStack class:

MaxStack() Initializes the stack object.
void push(int x) Pushes element x onto the stack.
int pop() Removes the element on top of the stack and returns it.
int top() Gets the element on the top of the stack without removing it.
int peekMax() Retrieves the maximum element in the stack without removing it.
int popMax() Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one.
  
Input
["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"]
[[], [5], [1], [5], [], [], [], [], [], []]
Output
[null, null, null, null, 5, 5, 1, 5, 1, 5]  

class MaxStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    //int max = Integer.MIN_VALUE这里不能用全局变量，因为max值随着操作会变化
    public MaxStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
        int max = stack2.isEmpty() ? x : stack2.peek();
        if (x > max) {
            stack2.push(x);
        } else {
            stack2.push(max);
        }
    }
    
    public int pop() {
        stack2.pop();
        return stack1.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int peekMax() {
        return stack2.peek();
    }
    //pop需要单独操作
    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();
        while (top()!= max) buffer.push(pop());
        pop();//pop max
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
