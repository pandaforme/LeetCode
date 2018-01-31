package _725;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode [" +
                "val=" + val +
                ", next=" + next +
                "]";
    }
}

class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        return helper(root, k).toArray(new ListNode[k]);
    }

    private List<ListNode> helper(ListNode root, int k) {
        List<ListNode> result = new ArrayList<>();
        if (k == 0)
            return result;
        if (root == null) {
            result.add(null);
            return result;
        }

        int length = length(root);

        int number = (int) Math.ceil((double) length / (double) k);
        ListNode walkRoot = root;
        ListNode walkNode = new ListNode(walkRoot.val);
        ListNode newNode = walkNode;
        result.add(newNode);
        for (int i = 1; i < number; i++) {
            walkRoot = walkRoot.next;
            walkNode.next = new ListNode(walkRoot.val);
            walkNode = walkNode.next;
        }

        walkRoot = (walkRoot == null) ? null : walkRoot.next;
        result.addAll(helper(walkRoot, k - 1));

        return result;

    }

    private int length(ListNode root) {
        if (root == null)
            return 0;

        return 1 + length(root.next);
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode senven = new ListNode(7);
        ListNode eight = new ListNode(8);
        ListNode nine = new ListNode(9);
        ListNode ten = new ListNode(10);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = senven;
        senven.next = eight;
        eight.next = nine;
        nine.next = ten;

        System.out.println(Arrays.toString(new Solution().splitListToParts(one, 3)));
    }
}
