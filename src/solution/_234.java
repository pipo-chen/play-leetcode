package solution;

import common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class _234 {
    public boolean isPalindrome(ListNode head) {
        /**
         * 用栈的话 除非找到中间的数
         * 找到之前全部 push
         */
        Stack<Integer> stack = new Stack<>();

        ListNode p = head, q = head;
        if (head == null)
            return true;

        while (p.next != null) {
            stack.push(q.val);
            System.out.println(q.val);
            p = p.next;
            q = q.next;
            if (p.next != null) {
                p = p.next;
            }
        }
        //剩下的出栈 如果是奇数
        while (q != null) {
            if (stack.isEmpty() && q.next == null) {
                return true;
            }

            if (!stack.isEmpty() && stack.peek() == q.val) {
                stack.pop();
            }
            q = q.next;
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(1);
        ListNode head = ListNode.createSinglyLinkedList(list);
        boolean res = new _234().isPalindrome(head);
        System.out.println(res);
    }

}
