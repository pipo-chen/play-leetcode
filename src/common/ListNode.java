package common;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public int getVal() {
        return val;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public static ListNode createSinglyLinkedList(List<Integer> listValues) {
        if (listValues == null || listValues.size() == 0) {
            throw new IllegalArgumentException(
                    "please pass in a valid listValues to create a singly linked list."
            );
        }
        ListNode head = new ListNode(listValues.get(0));
        ListNode temp = head;
        for (int i = 1; i<listValues.size();i++) {
            ListNode next = new ListNode(listValues.get(i));
            temp.next = next;
            temp = temp.next;
        }
        printList(head);
        return head;
    }

    public static void printList(ListNode head) {
        System.out.println("开始打印链表：");
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}
