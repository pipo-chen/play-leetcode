package review;

import common.ListNode;

import java.util.ArrayList;

public class _2_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode head = res;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + flag;
            int num = sum % 10;
            ListNode cur = new ListNode(num);
            head.next = cur;
            head = cur;

            flag = sum > 9 ? 1 : 0;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (flag == 1) {
            head.next = new ListNode(1);
        }
        return res.next;
    }

    public static void main(String[] args) {
        ArrayList nums1 = new ArrayList();
        ArrayList nums2 = new ArrayList();
        nums1.add(1);
//        nums1.add(4);
//        nums1.add(3);
//        nums2.add(5);
        nums2.add(9);
        nums2.add(9);
        ListNode l1 = ListNode.createSinglyLinkedList(nums1);
        ListNode l2 = ListNode.createSinglyLinkedList(nums2);
        ListNode res = new _2_2().addTwoNumbers(l1,l2);
        ListNode.printList(res);
    }
}
