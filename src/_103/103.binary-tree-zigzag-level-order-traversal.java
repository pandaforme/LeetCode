package _103;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isRightWay = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> list = new ArrayList<>();
            List<TreeNode> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (isRightWay)
                    list.add(node.val);
                else
                    list.add(0, node.val);

                if (node.left != null)
                    tmp.add(node.left);

                if (node.right != null)
                    tmp.add(node.right);
            }

            lists.add(list);
            isRightWay = !isRightWay;
            queue.addAll(tmp);
        }

        return lists;
    }
}
