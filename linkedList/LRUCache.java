package linkedList;

import java.util.HashMap;
public class LRUCache {
    HashMap<Integer, Node> key2Node = new HashMap<>();
    Node tail = new Node(-1, -1);
    Node dummyNode = new Node(-1, -1);
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyNode.next = tail;
        tail.prev = dummyNode;
    }

    public int get(int key) {
        if (!key2Node.containsKey(key)) {
            return -1;
        }
        else {
            Node targetNode = key2Node.get(key);
            moveToHead(targetNode);
            return targetNode.val;
        }
    }

    public void put(int key, int value) {
        if (key2Node.containsKey(key)) {
            Node targetNode = key2Node.get(key);
            targetNode.val = value;
            moveToHead(targetNode);
        } else {
            Node newNode = new Node(key, value);
            key2Node.put(key, newNode);
            addHead(newNode);
            // 如果容量已满，那么删除尾部节点
            if (key2Node.size() > capacity) {
                removeTail();
            }
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addHead(node);
    }

    private void removeTail() {
        Node node = tail.prev;
        key2Node.remove(node.key);
        removeNode(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addHead (Node node) {
        node.next = dummyNode.next;
        node.next.prev = node;

        dummyNode.next = node;
        node.prev = dummyNode;
    }


    private static class Node {
        Integer key;
        Integer val;
        Node next;
        Node prev;

        Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(3, 4);
    }
}
