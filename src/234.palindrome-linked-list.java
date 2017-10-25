///**
// * Definition for singly-linked list.
// * public class ListNode {
// * int val;
// * ListNode next;
// * ListNode(int x) { val = x; }
// * }
// */
//class Solution {
//    public boolean isPalindrome(ListNode head) {
//        if (head == null)
//            return true;
//
//        ListNode middle = findMiddle(head);
//
//        ListNode tmp = head;
//        ListNode reverse = reverse(middle);
//
//        while (reverse != null) {
//            if (reverse.val != tmp.val)
//                return false;
//
//            reverse = reverse.next;
//            tmp = tmp.next;
//        }
//
//        return true;
//    }
//
//    private ListNode reverse(ListNode start) {
//        ListNode result = null;
//
//        while (start != null) {
//            ListNode tmp = start.next;
//            start.next = result;
//            result = start;
//            start = tmp;
//        }
//
//        return result;
//    }
//
//    private ListNode findMiddle(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//
//        return slow;
//    }
//}