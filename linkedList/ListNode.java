package linkedList;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    public static ListNode createLinkedNodeList(List<Integer> vals) {
        ListNode dummyNode = new ListNode(-1), resultTail = dummyNode;
        for (int val : vals) {
            resultTail.next = new ListNode(val);
            resultTail = resultTail.next;
        }
        return dummyNode.next;
    }
}
