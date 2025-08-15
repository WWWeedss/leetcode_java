package anotherTime;

import linkedList.ListNode;

import java.util.Arrays;
import java.util.List;

public class Question234 {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMiddleNode(head);
        ListNode head2 = reverseListNode(mid).get(0);
        while(head != null && head2 != null) {
            if (head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
    ListNode getMiddleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // [0] 是反转后的 head，[1] 是反转后的 tail
    List<ListNode> reverseListNode(ListNode head) {
        if (head == null) return Arrays.asList(null, null);
        if (head.next == null) return Arrays.asList(head, head);
        List<ListNode> arr = reverseListNode(head.next);
        head.next = null;
        arr.get(1).next = head;
        return Arrays.asList(arr.get(0), head);
    }
}
