package solution;

import common.ListNode;

import java.util.ArrayList;

public class _19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = null;
        // p 与 q 保持的距离为 n+1;
        while (head != null && n > 0) {
            q = head.next;
            head = head.next;
            n--;
        }
        //q到达指定位置
        while (q !=null ) {
            p = p.next;
            q = q.next;
        }
        //p 的下一个元素要删除
        if (p != null)
            p.next = p.next.next;

        return dummyHead.next;
    }
    public static void main(String[] args) {
        ArrayList value = new ArrayList();
        value.add(1);
        value.add(2);
        value.add(3);
        value.add(4);
        value.add(5);
        ListNode l1 = ListNode.createSinglyLinkedList(value);
        ListNode result = new _19().removeNthFromEnd(l1, 1);
        ListNode.printList(result);
    }
}
