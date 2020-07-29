package solution;

import common.ListNode;

import java.util.ArrayList;

public class _24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ArrayList value = new ArrayList();
        value.add(1);
        value.add(2);
        value.add(3);
        value.add(4);
        value.add(5);
        ListNode node = ListNode.createSinglyLinkedList(value);
        ListNode result = new _24().reverseList(node);
        ListNode.printList(result);
    }
}
