package solution;

import common.ListNode;

import java.util.ArrayList;

public class _21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : l2.val + 1;
            int v2 = l2 != null ? l2.val : l1.val + 1;
            int min = v1 < v2 ? v1 : v2;
            //比较哪边的元素小 就存哪边
            cur.next = new ListNode(min);
            //看需要移动的是哪边
            if (min == v1)
                l1 = l1 != null ? l1.next : null;
            else
                l2 = l2 != null ? l2.next : null;

            cur = cur.next;
        }

        return res.next;
    }
    public static void main(String[] args) {
        ArrayList data_1 = new ArrayList();
        data_1.add(1);
        data_1.add(2);
        data_1.add(4);
        ArrayList data_2 = new ArrayList();
        data_2.add(1);
        data_2.add(3);
        data_2.add(4);
        ListNode l1 = ListNode.createSinglyLinkedList(data_1);
        ListNode l2 = ListNode.createSinglyLinkedList(data_2);
        ListNode res = new _21().mergeTwoLists(l1,l2);
        ListNode.printList(res);
    }

}
