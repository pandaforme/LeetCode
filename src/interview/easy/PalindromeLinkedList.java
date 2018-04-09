package interview.easy;

import datastructure.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode middle = findMiddle(head);
        ListNode reverseList = reverseList(middle);
        while (head != null && reverseList != null) {
            if (head.val != reverseList.val)
                return false;

            head = head.next;
            reverseList = reverseList.next;
        }


        return true;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
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
