package _160;

import datastructure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        int diff = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }

        } else if (lengthA < lengthB) {
            for (int i = 0; i < diff; i++) {
                headB = headB.next;
            }
        }

        return intersect(headA, headB);
    }

    private ListNode intersect(ListNode headA, ListNode headB) {
        while (headA != null) {
            if (headA == headB)
                return headA;
            else {
                headA = headA.next;
                headB = headB.next;
            }
        }

        return null;
    }

    private int getLength(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}
