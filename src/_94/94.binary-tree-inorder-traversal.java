package _94;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

//    // Recursive solution
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null)
//            return new ArrayList<>();
//
//        List<Integer> list = new ArrayList<>();
//        list.addAll(inorderTraversal(root.left));
//        list.add(root.val);
//        list.addAll(inorderTraversal(root.right));
//
//        return list;
//    }

    // Iterative solution
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // add all left nodes
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode node = stack.pop();
            list.add(node.val);

            current = node.right;
        }

        return list;
    }
}
