package interview.easy;

import datastructure.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        if (root.left != null && root.right == null)
            return false;

        if (root.left == null && root.right != null)
            return false;

        if (root.left.val != root.right.val)
            return false;

        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;

        if (t1 != null && t2 == null)
            return false;

        if (t1 == null && t2 != null)
            return false;

        if (t1.val != t2.val)
            return false;

        return isSame(t1.left, t2.right) && isSame(t1.right, t2.left);
    }
}
