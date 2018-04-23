package datastructure;

public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;

    @Override
    public String toString() {
        return "TreeLinkNode [" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                "]";
    }

    public TreeLinkNode(int x) {
        val = x;
    }
}
