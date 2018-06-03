package _105;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preorderStart, int preorderEnd,
                            int[] inorder, int inorderStart, int inorderEnd) {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preorderStart]);

        int rootIndex = findTarget(inorder, inorderStart, inorderEnd, preorder[preorderStart]);

        root.left = helper(preorder, preorderStart + 1, (rootIndex - inorderStart + preorderStart),
                inorder, inorderStart, rootIndex - 1);

        root.right = helper(preorder, (rootIndex - inorderStart + preorderStart + 1), preorderEnd,
                inorder, rootIndex + 1, inorderEnd);

        return root;
    }

    private int findTarget(int[] a, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (a[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
