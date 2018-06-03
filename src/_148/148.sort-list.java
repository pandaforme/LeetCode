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

        if (previous != null)
            previous.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        ListNode root = null;
        ListNode rootPointer = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ListNode node = new ListNode(l1.val);
                if (root == null) {
                    root = node;
                    rootPointer = root;
                } else {
                    rootPointer.next = node;
                    rootPointer = rootPointer.next;
                }

                l1 = l1.next;
            } else {
                ListNode node = new ListNode(l2.val);
                if (root == null) {
                    root = node;
                    rootPointer = root;
                } else {
                    rootPointer.next = node;
                    rootPointer = rootPointer.next;
                }

                l2 = l2.next;
            }
        }

        if (l1 != null)
            rootPointer.next = l1;

        if (l2 != null)
            rootPointer.next = l2;

        return root;
    }

    public static void main(String[] args) {
        ListNode r = new ListNode(4);
        ListNode r1 = new ListNode(2);
        ListNode r2 = new ListNode(1);
        ListNode r3 = new ListNode(3);
        r.next = r1;
        r1.next = r2;
        r2.next = r3;
        new Solution().sortList(r);
    }
}
