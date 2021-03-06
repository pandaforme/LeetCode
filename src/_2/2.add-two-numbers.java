package _2;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        ListNode result = null;
        ListNode resultPointer = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            ListNode tmp = new ListNode((l1.val + l2.val + carry) % 10);

            if (result == null) {
                result = tmp;
                resultPointer = result;
            } else {
                resultPointer.next = tmp;
                resultPointer = tmp;
            }

            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ListNode tmp = new ListNode((l1.val + carry) % 10);

            if (result == null) {
                result = tmp;
                resultPointer = result;
            } else {
                resultPointer.next = tmp;
                resultPointer = tmp;
            }

            carry = (l1.val + carry) / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode tmp = new ListNode((l2.val + carry) % 10);

            if (result == null) {
                result = tmp;
                resultPointer = result;
            } else {
                resultPointer.next = tmp;
                resultPointer = tmp;
            }

            carry = (l2.val + carry) / 10;
            l2 = l2.next;
        }

        if (carry > 0) {
            resultPointer.next = new ListNode(carry);
        }

        return result;
    }
}
