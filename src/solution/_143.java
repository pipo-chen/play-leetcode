package solution;

import common.ListNode;

import java.util.ArrayList;

public class _143 {
    public void reorderList(ListNode head) {

       //先找到中间节点
        //反转后半段节点
        //组装

        ListNode p = head, q = head , r, s = head;

        if (head == null)
            return;

        //找中间
        while (q.next != null) {
            q = q.next;
            p = p.next;
            if (q.next != null)
                q = q.next; //q 走两步
        }
        q = p.next; // p为中间，q 为后半段的起始点
        p.next = null;
        //逆序后半段
        while (q != null) {
            r = q.next;
            q.next = p.next;
            p.next = q;
            q = r;
        }
        q = p.next; //q 指向后半段第一个数据节点
        p.next = null;
        while (q != null) {
            r = q.next;
            q.next = s.next;
            s.next = q;
            s = q.next;
            q = r; //s 指向前半段的下一个插入点
        }

    }

    public static void main(String[] args) {
        ArrayList data = new ArrayList();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        ListNode head = ListNode.createSinglyLinkedList(data);
        new _143().reorderList(head);
        ListNode.printList(head);
    }
}
