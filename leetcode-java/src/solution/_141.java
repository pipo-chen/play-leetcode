package solution;

import common.ListNode;
/**
 * 快慢来比赛
 * 套圈即是还
 */

import java.util.ArrayList;

public class _141 {
     public boolean hasCycle(ListNode head) {
         ListNode fast = head;
         ListNode slow = head;
         if (head == null)
             return false;
         while (fast != null && fast.next != null) {
             fast = fast.next.next;
             slow = slow.next;
             if (fast == slow)
                 return true;
         }

         return false;
    }
    public static void main(String[] args) {
        ArrayList value = new ArrayList();
        value.add(3);
        value.add(2);
        value.add(0);
        value.add(-4);
        ListNode head = ListNode.createSinglyLinkedList(value);
        boolean result = new _141().hasCycle(head);
        System.out.println(result);
    }
}
