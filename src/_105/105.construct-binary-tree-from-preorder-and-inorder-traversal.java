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

    private TreeNode helper(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd)
            return null;

        TreeNode root = new TreeNode(preorder[pStart]);
        int index = find(inorder, preorder[pStart], iStart, iEnd);
        root.left = helper(preorder, inorder, pStart + 1, index - iStart + pStart, iStart, index - 1);
        root.right = helper(preorder, inorder, index - iStart + pStart + 1, pEnd, index + 1, iEnd);

        return root;
    }

    private int find(int[] a, int target, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (a[i] == target)
                return i;
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}).toString());
    }
}
