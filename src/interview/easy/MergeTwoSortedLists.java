package interview.easy;

import datastructure.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;

        if (l1 != null && l2 == null)
            return l1;

        if (l1 == null && l2 != null)
            return l2;

        ListNode result = null;
        ListNode tmpResult = null;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val <= tmp2.val) {
                if (result == null) {
                    result = new ListNode(tmp1.val);
                    tmpResult = result;
                } else {
                    ListNode node = new ListNode(tmp1.val);
                    tmpResult.next = node;
                    tmpResult = node;
                }

                tmp1 = tmp1.next;
            } else {
                if (result == null) {
                    result = new ListNode(tmp2.val);
                    tmpResult = result;
                } else {
                    ListNode node = new ListNode(tmp2.val);
                    tmpResult.next = node;
                    tmpResult = node;
                }

                tmp2 = tmp2.next;
            }
        }

        if (tmp1 != null)
            tmpResult.next = tmp1;
        else if (tmp2 != null)
            tmpResult.next = tmp2;

        return result;
    }
}
