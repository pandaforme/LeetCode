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

        if (head.next == null)
            return head;

        if (head.next.next == null)
            return head;

        ListNode headPointer = head;
        ListNode evenHead = null;
        ListNode oddTail = null;
        int count = 1;
        while (headPointer.next != null) {
            if (count == 1)
                evenHead = headPointer.next;

            ListNode tmp = headPointer.next;
            headPointer.next = headPointer.next.next;

            oddTail = headPointer;
            headPointer = tmp;
            count++;
        }

        if (count % 2 == 1)
            headPointer.next = evenHead;
        else
            oddTail.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);


        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        ListNode listNode = new Solution().oddEvenList(one);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
