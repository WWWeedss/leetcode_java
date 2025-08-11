package linkedList;

import java.util.Arrays;
import java.util.List;

public class Question206_Recursion {
    public ListNode reverseList(ListNode head) {
        return doReverseList(head).get(0);
    }

    // [0] 是反转后的头节点，[1] 是反转后的尾节点
    private List<ListNode> doReverseList(ListNode head) {
        if (head == null) return Arrays.asList(null, null);
        if (head.next == null) return Arrays.asList(head, head);
        List<ListNode> reverseResult = doReverseList(head.next);
        ListNode nextTail = reverseResult.get(1);
        ListNode nextHead = reverseResult.get(0);
        nextTail.next = head;
        head.next = null;
        return Arrays.asList(nextHead, head);
    }
}
