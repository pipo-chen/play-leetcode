package solution;

import common.ListNode;

import java.util.ArrayList;

public class _22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        while (head == null)
            return head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }

        ListNode cur = head;

        for (int i = 0; i < len - k; i++) {
            cur = cur.next;
        }
        return cur;
    }
    public static void main(String[] args) {
        ArrayList value = new ArrayList();
        value.add(1);
        value.add(2);
        value.add(3);
        value.add(4);
        value.add(5);
        ListNode head = ListNode.createSinglyLinkedList(value);
        ListNode result = new _22().getKthFromEnd(head, 5);
        ListNode.printList(result);
    }
}
