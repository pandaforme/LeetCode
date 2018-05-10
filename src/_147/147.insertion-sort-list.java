package _147;//import datastructure.ListNode;

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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode sorted = head;
        ListNode unsorted = head.next;
        sorted.next = null;

        while (unsorted != null) {
            ListNode previous = null;
            while (sorted != null && sorted.val < unsorted.val) {
                previous = sorted;
                sorted = sorted.next;
            }

            ListNode nextUnsorted = unsorted.next;

            if (previous == null) {
                unsorted.next = sorted;
                head = unsorted;
            } else {
                ListNode tmp = previous.next;
                previous.next = unsorted;
                unsorted.next = tmp;
            }

            unsorted = nextUnsorted;
            sorted = head;
        }

        return head;
    }
}
