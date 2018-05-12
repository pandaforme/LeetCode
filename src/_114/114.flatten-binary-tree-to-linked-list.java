package _114;//import datastructure.TreeNode;

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
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.left);
        flatten(root.right);

        if (root.left != null) {
            TreeNode tmp = root.left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }

            tmp.right = root.right;
            root.right = root.left;
            root.left = null;
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

        new Solution().flatten(three);

        while (three != null) {
            System.out.println(three.val);
            three = three.right;
        }
    }
}
