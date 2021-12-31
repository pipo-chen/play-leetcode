package review;

import common.ListNode;

import java.util.ArrayList;

public class _2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + carry;
            int result = sum % 10;
            //创建node
            curr.next = new ListNode(result);
            carry = sum > 9 ? 1 : 0;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            curr = curr.next;
        }
        if (carry == 1) {
            //继续创建一个
            curr.next = new ListNode(1);
        }
        return dummyHead.next;
    }

    public static void main(String args[]) {
        ArrayList value_1 = new ArrayList();
        value_1.add(1);
        value_1.add(0);
        value_1.add(5);
        ArrayList value_2 = new ArrayList();
        value_2.add(9);
        value_2.add(1);
        ListNode l1 = ListNode.createSinglyLinkedList(value_1);
        ListNode l2 = ListNode.createSinglyLinkedList(value_2);
        ListNode sumList = _2.addTwoNumbers(l1,l2);
        System.out.println("求和之后结果为：");
        ListNode.printList(sumList);

    }

}
