package interview.easy;

import datastructure.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;


        return node;
    }


    public ListNode reverseList1(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = previous;
            previous = current;
            current = tmp;
        }

        return previous;
    }
}
