package solution;

import common.ListNode;

import java.util.ArrayList;


public class _06 {
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        int length = 0;
        while (p !=null) {
            p = p.next;
            length ++;
        }
        int[] res = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }
    public static void main(String[] args) {
        ArrayList values = new ArrayList();
        values.add(1);
        values.add(3);
        values.add(2);
        ListNode head = ListNode.createSinglyLinkedList(values);
        int[] res = new _06().reversePrint(head);
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i]+"  ");
    }
}
