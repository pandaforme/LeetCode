package _285;

import datastructure.TreeNode;

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null)
            return null;

        TreeNode result = null;
        while (root != null) {
            if (p.val < root.val) {
                result = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return result;
    }

    // recursive solution
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        if (root == null || p == null)
//            return null;
//
//        if (p.val < root.val) {
//            TreeNode successor = inorderSuccessor(root.left, p);
//            return successor == null ? root : successor;
//        }else {
//            return inorderSuccessor(root.right, p);
//        }
//    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        two.left = one;

        System.out.println(new Solution().inorderSuccessor(two, one).val);
    }
}
