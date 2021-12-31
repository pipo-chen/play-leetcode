package review;

import common.ListNode;

import java.util.ArrayList;

public class _328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode evenHead = new ListNode(-1);
        ListNode even = evenHead;
        while (odd != null && odd.next != null) {
            ListNode next = odd.next;
            odd.next = next.next;
            next.next = null;
            even.next = next;
            even = next;
            if (odd.next != null) {
                odd = odd.next;
            }
        }
        odd.next = evenHead.next;
        return head;
    }
    public static void main(String[] args) {
        ArrayList num = new ArrayList();
        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);
        num.add(5);
        ListNode head = ListNode.createSinglyLinkedList(num);
        ListNode res = new _328().oddEvenList(head);
        ListNode.printList(res);
    }
}
