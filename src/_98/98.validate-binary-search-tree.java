package _98;

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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        long leftTreeMax = Long.MIN_VALUE;
        long rightTreeMin = Long.MAX_VALUE;

        TreeNode tmp = root.left;
        while (tmp != null) {
            leftTreeMax = tmp.val;
            tmp = tmp.right;
        }

        tmp = root.right;
        while (tmp != null) {
            rightTreeMin = tmp.val;
            tmp = tmp.left;
        }

        if (leftTreeMax < root.val && root.val < rightTreeMin) {
            return isValidBST(root.left) && isValidBST(root.right);
        }

        return false;
    }
}
