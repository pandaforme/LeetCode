package interview.easy;

import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            List<TreeNode> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    tmp.add(node.left);
                }

                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            result.add(list);

            queue.addAll(tmp);
        }

        return result;
    }
}
