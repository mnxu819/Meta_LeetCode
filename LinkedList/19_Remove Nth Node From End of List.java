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
*********************************************************************************************
Given the head of a singly linked list and two integers left and right where left <= right,
reverse the nodes of the list from position left to position right, and return the reversed list.
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode tmpHead1 = dummy;
        ListNode tmpHead2 = dummy;
        int count = 0;
        while (cur != null) {
            count++;
            if (count == left) {
                tmpHead1 = pre;
                tmpHead2 = cur;
            }
            if (count < right && count > left) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
                continue;
            }
            if (count == right) {
                tmpHead2.next = cur.next;// 2->5
                cur.next = pre;
                tmpHead1.next = cur;
                break;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
  
