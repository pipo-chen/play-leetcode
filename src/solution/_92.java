package solution;

import common.ListNode;

import java.util.ArrayList;

public class _92 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n)
            return head;

        return null;
    }

    public static void main(String[] args) {
        ArrayList values = new ArrayList();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
        ListNode l = ListNode.createSinglyLinkedList(values);
        ListNode p = _92.reverseBetween(l, 2, 4);
        ListNode.printList(p);
    }

}
