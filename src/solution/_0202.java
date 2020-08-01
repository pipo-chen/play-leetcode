package solution;

import common.ListNode;

import java.util.ArrayList;

public class _0202 {
    public int kthToLast(ListNode head, int k) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        int pos = len - k;
        for (int i = 1; i < pos + 1; i++) {
            head = head.next;
        }
        return head.val;

    }
    public static void main(String[] args) {
        ArrayList data = new ArrayList();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(5);
        ListNode head = ListNode.createSinglyLinkedList(data);
        int res = new _0202().kthToLast(head, 2);
        System.out.println(res);
    }
}
