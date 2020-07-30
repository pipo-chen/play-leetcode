package solution;

import common.ListNode;
import sun.jvm.hotspot.memory.LinearAllocBlock;

import java.util.ArrayList;

public class _61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        if (k == 0)
            return head;
        int len = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        //找到最尾部 将尾部指向头部
        p.next = head;
        //找到循环链表实际的尾部node node.next 设置为实际链表的头部之后， node.next = null.
        int pos = len - (k % len);
        //注意当前p处于实际的尾部 所以 i 从 0 开始 抵达实际的 pos 所在
        for (int i = 0; i < pos; i++)
            p = p.next;
        ListNode result = p.next;
        p.next = null;

        return result;
    }
    public static void main(String[] args) {
        ArrayList value = new ArrayList();

        value.add(1);
        value.add(2);
        value.add(3);
        value.add(4);
        value.add(5);
        ListNode head = ListNode.createSinglyLinkedList(value);
        ListNode result = new _61().rotateRight(head, 2);
        ListNode.printList(result);
    }

    private ListNode rotateRight_me(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        //1. 做成一个循环链表
        //2. 在  位置断开
        ListNode cycleList = new ListNode(-1);
        cycleList.next = head;
        ListNode cur = cycleList;
        int len = 0;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }

        cur.next = head;
        //是一个循环链表 则在循环链表
        ListNode tail = cycleList.next;
        int pos = len - (k % len);
        for (int i = 1; i < pos; i++) {
            tail = tail.next;
        }
        //在将其置为null之前
        ListNode result = tail.next;
        tail.next = null;
        return result;
    }
}
