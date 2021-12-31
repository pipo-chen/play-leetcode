package solution;

import common.ListNode;

import java.util.ArrayList;

public class _2424 {
    public ListNode swapPairs(ListNode head) {
//        两两交换 穿针引线
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode per = dummyHead;
        while (per.next != null && per.next.next != null) {
            ListNode node1 = per.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            per.next = node2;
            per = node1;
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {
        ArrayList value = new ArrayList();
        value.add(1);
        value.add(2);
        value.add(3);
        value.add(4);
        ListNode head = ListNode.createSinglyLinkedList(value);
        ListNode result = new _2424().swapPairs(head);
        ListNode.printList(result);
    }
}
