Given the head of a linked list, return the list after sorting it in ascending order.
  
O(1)+O(NlogN)


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
    public ListNode sortList(ListNode head) {
    return mergeSort(head);
}
private ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy;
    ListNode slow = dummy;
    //快慢指针找中点
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    ListNode head2 = slow.next;
    slow.next = null;
    head = mergeSort(head);
    head2 = mergeSort(head2);
    return merge(head, head2);
}
private ListNode merge(ListNode head1, ListNode head2) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (head1 != null && head2 != null) {
        if (head1.val < head2.val) {
            tail.next = head1;
            tail = tail.next;
            head1 = head1.next;
        } else {
            tail.next = head2;
            tail = tail.next;
            head2 = head2.next;
        }
    }
    if (head1 != null) {
        tail.next = head1;
    }
    if (head2 != null) {
        tail.next = head2;
    }
    return dummy.next;
}
}
