package solution;

import common.ListNode;

import java.util.ArrayList;

public class _206 {
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
        ArrayList values = new ArrayList();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
        ListNode head = ListNode.createSinglyLinkedList(values);
        ListNode result = new _206().reverseList(head);
        ListNode.printList(result);
    }
}
