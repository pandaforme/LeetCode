package _230;

import datastructure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int count = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);

        return result;
    }

    private void helper(TreeNode root, int k) {
        if (root == null)
            return;

        helper(root.left, k);

        if (++count == k)
            result = root.val;

        if (k > count) {
            helper(root.right, k);
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        three.left = two;
        two.left = one;
        three.right = four;
        four.right = five;

        System.out.println(new Solution().kthSmallest(three, 5));
    }
}
