Given the head of a linked list, remove the nth node from the end of the list and return its head.
  
//快慢指针，先让快指针走n次，这样慢指针和快指针一起走，直到快指针到尾部，删掉。因为有可能头文件被删掉要用dummy
  
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy= new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = slow;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
