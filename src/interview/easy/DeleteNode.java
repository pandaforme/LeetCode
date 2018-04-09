package interview.easy;

import datastructure.ListNode;

public class DeleteNode {
    // a odd question, first of all, you need to understand the question and constraints...
    public void deleteNode(ListNode node) {
        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        } else {
            node = null;
        }
    }
}
