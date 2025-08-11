package graph;

class Trie {
    Node root = new Node();
    public Trie() {}

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.son[index] == null) {
                cur.son[index] = new Node();
            }
            cur = cur.son[index];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.son[index] == null) {
                return false;
            }
            cur = cur.son[index];
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (cur.son[index] == null) {
                return false;
            }
            cur = cur.son[index];
        }
        return true;
    }

    private static class Node {
        Node[] son = new Node[26];
        boolean end = false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
    }
}