package _98;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        if (isValidBST(root.left) && isValidBST(root.right)) {
            long max = findMax(root.left);
            long min = findMin(root.right);

            if (max < root.val && root.val < min)
                return true;

            return false;
        } else
            return false;

    }

    private long findMax(TreeNode root) {
        if (root == null)
            return Long.MIN_VALUE;

        if (root.right == null)
            return root.val;

        return findMax(root.right);
    }

    private long findMin(TreeNode root) {
        if (root == null)
            return Long.MAX_VALUE;

        if (root.left == null)
            return root.val;

        return findMin(root.left);
    }

}