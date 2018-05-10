package _445;

import datastructure.ListNode;

import java.util.Stack;

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
        if(l1 == null)
            return l2;

        if(l2 == null)
            return l1;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode result = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int value = stack1.pop() + stack2.pop() + carry;

            ListNode node = new ListNode(value % 10);
            if (result == null)
                result = node;
            else {
                node.next = result;
                result = node;
            }

            carry = value / 10;
        }

        while (!stack1.isEmpty()) {
            int value = stack1.pop() + carry;

            ListNode node = new ListNode(value % 10);
            if (result == null)
                result = node;
            else {
                node.next = result;
                result = node;
            }

            carry = value / 10;
        }

        while (!stack2.isEmpty()) {
            int value = stack2.pop() + carry;

            ListNode node = new ListNode(value % 10);
            if (result == null)
                result = node;
            else {
                node.next = result;
                result = node;
            }

            carry = value / 10;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = result;
            result = node;
        }

        return result;
    }
}
