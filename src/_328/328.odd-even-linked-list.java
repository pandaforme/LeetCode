package _328;

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;

        ListNode evenStarter = null;
        ListNode oddLaster = null;
        ListNode pointer = head;
        int count = 1;

        while (pointer != null) {
            ListNode tmp = pointer.next;

            if (count == 2)
                evenStarter = pointer;
            if (count % 2 == 1)
                oddLaster = pointer;

            if (tmp == null)
                break;

            pointer.next = tmp.next;
            pointer = tmp;
            count++;

        }

        oddLaster.next = evenStarter;

        return head;
    }
}
