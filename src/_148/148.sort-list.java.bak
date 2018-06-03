package _148;

import datastructure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = null;

        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        previous.next = null;
        return merge(sortList(head), sortList(slow));
    }

    private ListNode merge(ListNode start1, ListNode start2) {
        ListNode result = null;
        ListNode resultPointer = null;

        while (start1 != null && start2 != null) {
            if (start1.val <= start2.val) {
                if (result == null) {
                    result = start1;
                    resultPointer = start1;
                } else {
                    resultPointer.next = start1;
                    resultPointer = resultPointer.next;
                }

                start1 = start1.next;
            } else {
                if (result == null) {
                    result = start2;
                    resultPointer = start2;
                } else {
                    resultPointer.next = start2;
                    resultPointer = resultPointer.next;
                }

                start2 = start2.next;
            }
        }

        if (start1 != null) {
            resultPointer.next = start1;
        } else {
            resultPointer.next = start2;
        }

        return result;
    }
}
