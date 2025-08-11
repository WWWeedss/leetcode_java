package linkedList;

public class Question142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        // 没有环
        if (fast == null || fast.next == null) return null;

        ListNode pointer = head;
        while(pointer != slow) {
            pointer = pointer.next;
            slow = slow.next;
        }

        return pointer;
    }
}
