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
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd) {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd)
            return null;

        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);

        int inorderRootIndex = findTreeNode(inorder, inorderStart, inorderEnd, rootVal);

        // need to handle the indexes carefully
        TreeNode left = helper(preorder, inorder, preorderStart + 1, inorderRootIndex - inorderStart + preorderStart, inorderStart, inorderRootIndex - 1);
        TreeNode right = helper(preorder, inorder, inorderRootIndex + 1 + preorderEnd - inorderEnd, preorderEnd, inorderRootIndex + 1, inorderEnd);

        root.left = left;
        root.right = right;

        return root;
    }

    private int findTreeNode(int[] a, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (a[i] == target)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
