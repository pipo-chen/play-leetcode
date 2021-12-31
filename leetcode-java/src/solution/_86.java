package solution;

import common.ListNode;

import java.util.ArrayList;

public class _86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(-1);
        ListNode left = dummyHead;
        ListNode dummyHead_r = new ListNode(-1);
        ListNode right = dummyHead_r;
        while (head != null) {
            if (head.val >= x) {
                //存入右边
//                ListNode cur = new ListNode(head.val);
//                cur.next = right;
//                right = cur;
                right.next = new ListNode(head.val);
                right = right.next;
            } else {
                //存入左边
                left.next = new ListNode(head.val);
                left = left.next;
            }
            head = head.next;
        }
        left.next = dummyHead_r.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ArrayList data = new ArrayList();
        data.add(1);
        data.add(4);
        data.add(3);
        data.add(2);
        data.add(5);
        data.add(2);
        ListNode head = ListNode.createSinglyLinkedList(data);
        ListNode result = new _86().partition(head, 3);
        ListNode.printList(result);
    }

}
