package _297;

import datastructure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
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
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null";

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelp(list);
    }

    private TreeNode deserializeHelp(Queue<String> queue) {
        if (queue.size() == 0)
            return null;

        String s = queue.poll();
        if (s.equals("null"))
            return null;

        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = deserializeHelp(queue);
        root.right = deserializeHelp(queue);

        return root;
    }

    public static void main(String[] args) {
        final Codec codec = new Codec();
        System.out.println(codec.serialize(codec.deserialize("1,2,null,null,3,4,5")));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
