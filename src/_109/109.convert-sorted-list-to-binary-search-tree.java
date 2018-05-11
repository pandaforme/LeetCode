package _109;

import datastructure.ListNode;
import datastructure.TreeNode;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return new TreeNode(head.val);


        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = null;
        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        previous.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}
