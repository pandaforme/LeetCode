package interview.easy;

import datastructure.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }

        return false;
    }
}
