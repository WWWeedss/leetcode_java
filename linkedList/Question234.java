package linkedList;

import java.util.Arrays;
import java.util.List;

public class Question234 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        ListNode mid = middleNode(head);
        ListNode head2 = doReverseList(mid).get(0);

        while(head2 != null) {
            if (head2.val != head.val) return false;
            head2 = head2.next;
            head = head.next;
        }
        return true;
    }

    private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

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
