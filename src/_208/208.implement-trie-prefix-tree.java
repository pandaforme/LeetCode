package _208;

import java.util.HashMap;
import java.util.Map;

class Trie {
    private Map<Character, Trie> children;
    private boolean isLeaf;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        children = new HashMap<>();
        isLeaf = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie current = this;

        for (int i = 0; i < word.length(); i++) {
            if (!current.children.containsKey(word.charAt(i))) {
                Trie trie = new Trie();
                current.children.put(word.charAt(i), trie);
                current = trie;
            } else {
                current = current.children.get(word.charAt(i));
            }
        }

        current.isLeaf = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie current = this;

        for (int i = 0; i < word.length(); i++) {
            if (!current.children.containsKey(word.charAt(i))) {
                return false;
            } else {
                current = current.children.get(word.charAt(i));
            }
        }

        return current.isLeaf;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie current = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (!current.children.containsKey(prefix.charAt(i))) {
                return false;
            } else {
                current = current.children.get(prefix.charAt(i));
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
