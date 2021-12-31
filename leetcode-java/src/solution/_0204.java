package solution;

import common.ListNode;

import java.util.ArrayList;

public class _0204 {
    public ListNode partition(ListNode head, int x) {
        //正着插入 跟 倒着插入 两个链表
        ListNode res = new ListNode(-1);
        ListNode left = res;
        ListNode right = null;
        while (head != null) {
            int value = head.val;
            if (value < x) {
                //放入左链表 正着插入
                left.next = new ListNode(value);
                left = left.next;
            } else {
                //倒着插入
                ListNode cur = new ListNode(value);
                cur.next = right;
                right = cur;
            }
            head = head.next;
        }
        left.next = right;
        return res.next;
    }
    public static void main(String[] args) {
        ArrayList data = new ArrayList();
        data.add(3);
        data.add(5);
        data.add(8);
        data.add(5);
        data.add(10);
        data.add(2);
        data.add(1);
        ListNode head = ListNode.createSinglyLinkedList(data);
        ListNode result = new _0204().partition(head, 5);
        ListNode.printList(result);
    }
}
