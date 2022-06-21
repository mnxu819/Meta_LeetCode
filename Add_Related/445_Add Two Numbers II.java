You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.

Input: l1 = [7,2,4,3], 
         l2 = [5,6,4]
Output:     [7,8,0,7]

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
    
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
     
        ListNode dummy = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            ListNode newH = new ListNode((num1+num2+carry)%10);
            carry = (num1+num2+carry)/10 ;
            newH.next = dummy;
            dummy = newH;
        }
        return dummy;
    }
}
