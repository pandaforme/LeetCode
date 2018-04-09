package interview.easy;

import datastructure.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int middle = (int) (left + Math.ceil((right - left) / 2.0));

        TreeNode root = new TreeNode(nums[middle]);
        TreeNode leftChildren = helper(nums, left, middle - 1);
        TreeNode rightChildren = helper(nums, middle + 1, right);

        root.left = leftChildren;
        root.right = rightChildren;
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(node);
    }
}
