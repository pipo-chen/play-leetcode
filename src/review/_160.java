package review;

import common.ListNode;

public class _160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode la = headA;
        ListNode lb = headB;
        while (la != lb) {
            la = la == null ? headB : la.next;
            lb = lb == null ? headA : lb.next;

        }
        return la;
    }
}
