package _222;

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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // full binary tree
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            return countNodes(root.left) + (1 << rightHeight);
        }
    }

    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + getHeight(node.left);
    }
}
