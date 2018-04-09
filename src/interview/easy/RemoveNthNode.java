package interview.easy;

import datastructure.ListNode;

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // get rid of null or one node
        if (head == null || head.next == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        // move fast pointer
        int tmp = n;
        while (tmp != 0) {
            fast = fast.next;
            tmp--;
        }

        // move slow pointer
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow should be removed
        if (fast == null) {
            return slow.next;
        }

        // slow should not be removed
        slow.next = slow.next.next;

        return head;
    }
}
