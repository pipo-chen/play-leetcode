package solution;

import common.ListNode;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;

public class _0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //反向存放
        //正向存放考虑用栈，数据长度不一。
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = carry + v1 + v2;
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum > 9 ? 1 : 0;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry == 1) {
            p.next = new ListNode(1);
        }
        return head.next;
    }
    public static void main(String[] args) {
        ArrayList value = new ArrayList();
        value.add(1);
        value.add(8);
//        value.add(6);
        ArrayList value_2 = new ArrayList();
        value_2.add(0);
//        value_2.add(9);
//        value_2.add(2);
        ListNode l1 = ListNode.createSinglyLinkedList(value);
        ListNode l2 = ListNode.createSinglyLinkedList(value_2);
        ListNode result = new _0205().addTwoNumbers(l1,l2);
        ListNode.printList(result);
    }
}
