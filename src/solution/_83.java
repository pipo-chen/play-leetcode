package solution;

import common.ListNode;

import java.util.ArrayList;

public class _83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next !=null) {
            if (cur.val == cur.next.val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ArrayList values = new ArrayList();
        values.add(1);
        values.add(1);
        values.add(2);

        ListNode head = ListNode.createSinglyLinkedList(values);
        ListNode result = new _83().deleteDuplicates(head);
        ListNode.printList(result);
    }
}
