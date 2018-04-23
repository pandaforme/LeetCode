package _545;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            result.add(root.val);
            leftBoundary(root.left, result);
            // this is a trick...
            leaves(root.left, result);
            // this is a trick...
            leaves(root.right, result);
            rightBoundary(root.right, result);
        }

        return result;
    }

    private void leftBoundary(TreeNode root, List<Integer> result) {
        if (root == null || (root.left == null && root.right == null))
            return;

        result.add(root.val);

        if (root.left != null) {
            leftBoundary(root.left, result);
        } else {
            leftBoundary(root.right, result);
        }
    }

    private void rightBoundary(TreeNode root, List<Integer> result) {
        if (root == null || (root.left == null && root.right == null))
            return;

        if (root.right != null) {
            rightBoundary(root.right, result);
        } else {
            rightBoundary(root.left, result);
        }

        result.add(root.val);
    }

    private void leaves(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        if ((root.left == null && root.right == null)) {
            result.add(root.val);
        }

        leaves(root.left, result);
        leaves(root.right, result);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode senven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        TreeNode ten = new TreeNode(10);
        one.right = three;
        one.left = two;
        two.left = four;
        two.right = five;
        five.left = senven;
        five.right = eight;
        three.left = six;
        six.left = nine;
        six.right = ten;
        System.out.println(new Solution().boundaryOfBinaryTree(one));
    }
}
