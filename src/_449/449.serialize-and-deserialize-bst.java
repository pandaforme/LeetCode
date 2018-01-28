//package _449;

import java.util.StringTokenizer;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "n";

        if (root.left == null && root.right == null)
            return String.valueOf(root.val);

        return Stream.of(String.valueOf(root.val), serialize(root.left), serialize(root.right))
                .filter(s -> s != null && !s.isEmpty())
                .collect(joining(","));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.charAt(0) == 'n')
            return null;

        StringTokenizer stringTokenizer = new StringTokenizer(data, ",");
        Integer rootValue = Integer.valueOf(stringTokenizer.nextToken());
        TreeNode root = new TreeNode(rootValue);

        int beginIndex = rootValue.toString().length() + 1;
        int endIndex = beginIndex - 1;
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();

            if (token.equals("n")) {
                endIndex += 2;
                continue;
            }

            Integer integer = Integer.valueOf(token);
            if (integer >= rootValue) break;
            endIndex += integer.toString().length() + 1;
        }


        if (beginIndex < data.length()) {
            if (endIndex == data.length()) {
                root.left = deserialize(data.substring(beginIndex));
                root.right = null;
            } else {
                root.left = deserialize(data.substring(beginIndex, endIndex));
                root.right = deserialize(data.substring(endIndex + 1));
            }
        }

        return root;
    }

}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
