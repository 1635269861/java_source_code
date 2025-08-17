package test.suanfa;

import test.datastruct.ListNode;

public class SortOddEvenList {

    public ListNode sortOddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode[] list = partition(head);
        ListNode reverse = reverse(list[1]);
        return merge(list[0], list[1]);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy, cur1 = l1, cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }

    private ListNode[] partition(ListNode head) {
        ListNode evenHead = head.next;
        ListNode odd = head, even = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = null;
        return new ListNode[]{head, evenHead};
    }

}
