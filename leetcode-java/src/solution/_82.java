package solution;

import common.ListNode;

import java.util.ArrayList;

public class _82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        pre.next = head;
        ListNode cur = head;
        boolean jump_flag = false;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;

            if (cur.val == next.val) {
                cur.next = next.next;
                jump_flag = true;
            }
            else {
               if (jump_flag) {
                   pre.next = next;
               } else {
                   pre = cur;
               }
               cur = next;
               jump_flag = false;
            }
            if ((cur == null || cur.next == null) && jump_flag) {
                pre.next = null;
            }

       }
        return dummyHead.next;
    }
    public static void main(String[] args) {
        ArrayList value = new ArrayList();
        value.add(1);
        value.add(1);
        value.add(1);
        value.add(2);
        ListNode head = ListNode.createSinglyLinkedList(value);
        ListNode result = new _82().deleteDuplicates(head);
        ListNode.printList(result);
    }
}
