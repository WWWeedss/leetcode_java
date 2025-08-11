package linkedList;

public class Question206_Iteration {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode prev = null;
        ListNode next = head.next;
        while(next != null) {
            head.next = prev;
            ListNode next2 = next.next;
            next.next = head;

            prev = head;
            head = next;
            next = next2;
        }

        return head;
    }
}
