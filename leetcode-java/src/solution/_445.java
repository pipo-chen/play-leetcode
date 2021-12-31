package solution;

import com.sun.deploy.security.SelectableSecurityManager;
import common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class _445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode p = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = num1 + num2 + carry;
            carry = sum > 9 ? 1 : 0;

            //数字存入链表
            ListNode node = new ListNode(sum % 10);
            node.next = p;
            p = node;
        }

        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = p;
            p = node;
        }

        return p;
    }

    public static void main(String[] args) {
        ArrayList value_1 = new ArrayList();
        ArrayList value_2 = new ArrayList();
        value_1.add(5);
//        value_1.add(9);
        value_2.add(5);

//        value_1.add(3);
//        value_1.add(9);
//        value_1.add(9);
//        value_1.add(9);
//        value_1.add(9);
//        value_1.add(9);
//        value_1.add(9);
//
//        value_2.add(9);
//        value_2.add(6);
//        value_2.add(4);
//        value_2.add(0);
//        value_2.add(0);
        ListNode l1 = ListNode.createSinglyLinkedList(value_1);
        ListNode l2 = ListNode.createSinglyLinkedList(value_2);
        ListNode result = new _445().addTwoNumbers(l1,l2);
        ListNode.printList(result);
    }
}

/**
 * int sum1 = 0; int sum2 = 0; while (l1 != null || l2 != null) { if (l1 != null) sum1 = sum1 * 10 +
 * l1.val; if (l2 != null) sum2 = sum2 * 10 + l2.val; l1 = l1 != null ? l1.next : null; l2 = l2 !=
 * null ? l2.next : null; } int total = sum1 + sum2;// 超出int定义的长度 ListNode p = null; if (total == 0)
 * return new ListNode(0); while (total > 0) { int num = total % 10; ListNode node = new
 * ListNode(num); node.next = p; p = node; total /= 10; } return p;
 */
