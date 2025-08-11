package linkedList;

import java.util.HashMap;
import java.util.Map;

public class Question138 {
    Map<Node, Node> cachedNode = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(!cachedNode.containsKey(head)) {
            Node newHead = new Node(head.val);
            cachedNode.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
