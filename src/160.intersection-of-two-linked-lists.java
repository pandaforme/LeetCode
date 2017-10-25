///**
// * Definition for singly-linked list.
// * public class ListNode {
// * int val;
// * ListNode next;
// * ListNode(int x) {
// * val = x;
// * next = null;
// * }
// * }
// */
//public class Solution {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        int lengthA = length(headA);
//        int lengthB = length(headB);
//        ListNode tmpA = headA;
//        ListNode tmpB = headB;
//
//        if (lengthA > lengthB) {
//            int diff = lengthA - lengthB;
//            while (diff > 0) {
//                tmpA = tmpA.next;
//                diff--;
//            }
//
//            return find(tmpA, headB);
//        } else if (lengthB > lengthA) {
//            int diff = lengthB - lengthA;
//            while (diff > 0) {
//                tmpB = tmpB.next;
//                diff--;
//            }
//
//            return find(headA, tmpB);
//        } else
//            return find(headA, headB);
//    }
//
//    private ListNode find(ListNode headA, ListNode headB) {
//        ListNode tmpA = headA;
//        ListNode tmpB = headB;
//
//        while (tmpA != tmpB) {
//            tmpA = tmpA.next;
//            tmpB = tmpB.next;
//        }
//
//        return tmpA;
//    }
//
//    private int length(ListNode head) {
//        ListNode tmp = head;
//        int result = 0;
//        while (tmp != null) {
//            result++;
//            tmp = tmp.next;
//        }
//
//        return result;
//    }
//}