package _236;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null)
            return root;

        TreeNode leftLowestCommonAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode righttLowestCommonAncestor = lowestCommonAncestor(root.right, p, q);

        if (leftLowestCommonAncestor != null && righttLowestCommonAncestor != null)
            return root;

        if (leftLowestCommonAncestor == null)
            return righttLowestCommonAncestor;
        else
            return leftLowestCommonAncestor;
    }
}
