package datastructure;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String str) {
        TrieNode tmp = root;
        for (char c : str.toCharArray()) {
            if (!tmp.containsKey(c)) {
                tmp.put(c, new TrieNode());
            }

            tmp = tmp.get(c);
        }

        tmp.setLeaf(true);
    }

    public TrieNode searchPrefix(String str) {
        TrieNode tmp = root;

        for (char c : str.toCharArray()) {
            if (tmp.containsKey(c)) {
                tmp = tmp.get(c);
            } else {
                return null;
            }
        }

        return tmp;
    }

    public boolean startsWith(String prefix) {
        TrieNode tmp = searchPrefix(prefix);
        return tmp != null;
    }

    public boolean search(String word) {
        TrieNode tmp = searchPrefix(word);
        return tmp != null && tmp.isLeaf();
    }

    public String searchLongestPrefix(String str) {
        TrieNode tmp = root;

        StringBuilder prefix = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (tmp.containsKey(c) && (tmp.getChildren().size() == 1) && (!tmp.isLeaf())) {
                prefix.append(c);
                tmp = tmp.get(c);
            } else
                return prefix.toString();

        }

        return prefix.toString();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("happyword");
        System.out.println(trie.startsWith("happy"));
    }
}
