package interview.easy;

import datastructure.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        long max = findMax(root.left);
        long min = findMin(root.right);

        if (isValidBST(root.right) && isValidBST(root.left)) {
            return (max < root.val && root.val < min);
        }

        return false;
    }

    private long findMax(TreeNode node) {
        if (node == null)
            return Long.MIN_VALUE;

        while (node.right != null) {
            node = node.right;
        }

        return node.val;
    }

    private long findMin(TreeNode node) {
        if (node == null)
            return Long.MAX_VALUE;

        while (node.left != null) {
            node = node.left;
        }

        return node.val;
    }
}
