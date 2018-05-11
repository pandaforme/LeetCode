package _116;

import datastructure.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 * int val;
 * TreeLinkNode left, right, next;
 * TreeLinkNode(int x) { val = x; }
 * }
 */
class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null) {
            if (root.next != null)
                root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }

    // I misunderstood the question...
    // it need to be solved with O(1) memory
    // because I used Queue, I violated the rule...
//    public void connect(TreeLinkNode root) {
//        if (root == null)
//            return;
//
//        Queue<TreeLinkNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            List<TreeLinkNode> current = new ArrayList<>();
//            current.addAll(queue);
//            queue.clear();
//
//            Queue<TreeLinkNode> next = new LinkedList<>();
//            for (TreeLinkNode treeLinkNode : current) {
//                if (treeLinkNode.left != null)
//                    next.add(treeLinkNode.left);
//                if (treeLinkNode.right != null)
//                    next.add(treeLinkNode.right);
//            }
//
//            for (int i = 0; i + 1 < current.size(); i++) {
//                current.get(i).next = current.get(i + 1);
//            }
//
//            queue.addAll(next);
//        }
//    }

    public static void main(String[] args) {
        TreeLinkNode one = new TreeLinkNode(1);
        TreeLinkNode two = new TreeLinkNode(2);
        TreeLinkNode three = new TreeLinkNode(3);
        TreeLinkNode four = new TreeLinkNode(4);
        TreeLinkNode five = new TreeLinkNode(5);
        TreeLinkNode six = new TreeLinkNode(6);
        TreeLinkNode seven = new TreeLinkNode(7);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        new Solution().connect(one);

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(one);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Queue<TreeLinkNode> next = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeLinkNode treeLinkNode = queue.poll();
                System.out.println(treeLinkNode.val);
                System.out.println(treeLinkNode.next);
                next.add(treeLinkNode.left);
                next.add(treeLinkNode.right);
            }

            queue.addAll(next);
        }
    }
}
