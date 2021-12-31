package solution;

import common.ListNode;

import java.util.ArrayList;

public class _18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == val) {
                if (p.next.next != null) {
                    p.next = p.next.next;
                } else {
                    p.next = null;
                    break;
                }
            }
            p = p.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ArrayList value = new ArrayList();
        value.add(1);
        value.add(0);
        value.add(99);
        ListNode head = ListNode.createSinglyLinkedList(value);
        ListNode result = new _18().deleteNode(head, 99);
        ListNode.printList(result);
    }
}
