package interview.medium;

import datastructure.ListNode;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null | headB == null)
            return null;

        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        if (lengthA == lengthB)
            return find(0, 0, headA, headB);

        if (lengthA < lengthB)
            return find(0, lengthB - lengthA, headA, headB);

        return find(lengthA - lengthB, 0, headA, headB);
    }

    private ListNode find(int skip1, int skip2, ListNode node1, ListNode node2) {
        ListNode result = null;

        while (skip1 > 0) {
            node1 = node1.next;
            skip1--;
        }

        while (skip2 > 0) {
            node2 = node2.next;
            skip2--;
        }

        while (node1 != null && node2 != null) {
            if (node1 != node2 && result != null)
                return null;

            if (node1 == node2 && result == null)
                result = node1;

            node1 = node1.next;
            node2 = node2.next;
        }

        return result;
    }

    private int getLength(ListNode node) {
        if (node == null)
            return 0;

        return 1 + getLength(node.next);
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);

        one.next = two;
        two.next = three;
        three.next = four;

        seven.next = six;
        six.next = one;

        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(one, seven).val);

    }
}
