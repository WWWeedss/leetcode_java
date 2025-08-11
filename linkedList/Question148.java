package linkedList;

import java.util.Arrays;
import java.util.List;

public class Question148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 最少也会切成 2 + 1，所以多一种边界情况
        if (head.next.next == null) {
            ListNode nextNode = head.next;
            head.next = null;
            return mergeTwoLists(head, nextNode);
        }

        // 从中间切断后分别排序
        ListNode mid = middleNode(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode leftHead = sortList(head);
        rightHead = sortList(rightHead);

        return mergeTwoLists(leftHead, rightHead);
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

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head1 = list1, head2 = list2;
        ListNode dummyNode = new ListNode(-1), resultTail = dummyNode;
        while(head1 != null && head2 != null) {
            // 获取较小的下一个节点
            ListNode nextNode = null;
            if (head1.val > head2.val) {
                resultTail.next = head2;
                head2 = head2.next;
            } else {
                resultTail.next = head1;
                head1 = head1.next;
            }
            resultTail = resultTail.next;
        }
        if (head1 != null) resultTail.next = head1;
        if (head2 != null) resultTail.next = head2;

        return dummyNode.next;
    }

    public static void main(String[] args) {
        System.out.println(new Question148().sortList(ListNode.createLinkedNodeList(Arrays.asList(-1, 5, 3, 4, 0))));
    }
}
