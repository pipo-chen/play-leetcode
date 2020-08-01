package solution;

import common.ListNode;

import java.util.ArrayList;

public class _0208 {
    public ListNode detectCycle(ListNode head) {
        if (head != null && head.next != null) {
            ListNode fast = head;
            ListNode slow = head;
            fast = fast.next.next;
            slow = slow.next;
            while (fast != slow && fast != null && slow != null) {
                if (fast.next == null) {
                    return null;
                }
                fast = fast.next.next;
                slow = slow.next;
            }

            if (fast != null && slow != null) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        ArrayList value = new ArrayList();
        value.add(1);
        value.add(2);
//        value.add(0);
//        value.add(-4);
        ListNode head = ListNode.createSinglyLinkedList(value);
        ListNode result = new _0208().detectCycle(head);
        ListNode.printList(result);
    }
}
