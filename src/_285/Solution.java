package _285;

import datastructure.TreeNode;

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null)
            return null;
        if (p.val < root.val) {
            TreeNode successor = inorderSuccessor(root.left, p);
            return successor == null ? root : successor;
        } else {
            return inorderSuccessor(root.right, p);
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        two.left = one;

        System.out.println(new Solution().inorderSuccessor(two, one).val);
    }
}
