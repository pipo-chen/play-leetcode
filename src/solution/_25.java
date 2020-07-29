package solution;

import common.ListNode;

import java.util.ArrayList;

public class _25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = null;
        ListNode cur = dummyHead;
        ListNode node;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : l2.val + 1;
            int v2 = l2 != null ? l2.val : l1.val + 1;
            if (v1 < v2) {
                node = new ListNode(v1);
                l1 = l1 != null ? l1.next : null;
            } else {
                node = new ListNode(v2);
                l2 = l2 != null ? l2.next : null;
            }

            cur.next = node;
            cur = cur.next;
        }
        return dummyHead.next;

    }

    public static void main(String[] args) {
        ArrayList value_1 = new ArrayList();
        ArrayList value_2 = new ArrayList();
        value_1.add(5);
        value_2.add(5);

        ListNode l1 = ListNode.createSinglyLinkedList(value_1);
        ListNode l2 = ListNode.createSinglyLinkedList(value_2);
        ListNode result = new _25().mergeTwoLists(l1,l2);
        ListNode.printList(result);
    }

}
