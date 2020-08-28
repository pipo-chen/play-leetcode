package solution;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode node = dummyHead;
        ListNode oddHead = new ListNode(-1);
        ListNode odd = oddHead;
        while (node != null && node.next != null) {
            ListNode next = node.next;
            node.next = next.next;
            next.next = null;
            //放入奇数数组
            odd.next = next;
            odd = odd.next;
            node = node.next;
        }
        odd.next = dummyHead.next;
        return oddHead.next;
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
