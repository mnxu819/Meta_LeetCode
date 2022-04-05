Given the head of a singly linked list, reverse the list, and return the reversed list.

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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
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
            //记住前一个节点和当前节点
            if (count == left) {
                tmpHead1 = pre;
                tmpHead2 = cur;
            }
            //rever
            if (count < right && count > left) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
                continue;
            }
            //把头结点1的next设为当前的cur，头结点2的next设为cur.next，cur.next指向pre
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
  
