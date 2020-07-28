package solution;

import common.ListNode;

import java.util.ArrayList;

public class _92 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n)
            return head;

        ListNode pre = null;
        ListNode cur = head;
        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }
        //开始反转，但是要占主 pre 的起始位置
        ListNode pre2 = pre;
        ListNode cur2 = cur;
        for (int i = m; i <= n; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //拼接起来
        if (pre2 != null)
            pre2.next = pre;
        else
            head = pre;
        cur2.next = cur;

        return head;
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
