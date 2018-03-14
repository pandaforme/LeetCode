package datastructure;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private boolean isLeaf;
    private Map<Character, TrieNode> children;

    public TrieNode() {
        this.isLeaf = false;
        this.children = new HashMap<>();
    }

    public boolean containsKey(char c) {
        return this.children.containsKey(c);
    }

    public TrieNode get(char c) {
        return this.children.get(c);
    }

    public void put(char c, TrieNode node) {
        this.children.put(c, node);
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }
}
