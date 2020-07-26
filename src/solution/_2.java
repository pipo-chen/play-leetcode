package solution;

import common.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class _2 {
    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode curr = dummyHead;

            int carry = 0;
            while (l1 != null || l2 != null) {
                int v1 = l1!=null ? l1.val : 0;
                int v2 = l2!=null ? l2.val : 0;
                int sum = v1 + v2 + carry;
                curr.next = new ListNode(sum % 10);
                carry = sum > 9 ? 1 : 0;
                l1 = l1!=null ? l1.next : null;
                l2 = l2!=null ? l2.next:null;
                curr = curr.next;
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }
        public static void main(String[] args) {
            ArrayList<Integer> value_1 = new ArrayList();
            value_1.add(5);
            ArrayList<Integer> value_2 = new ArrayList();
            value_2.add(5);
            ListNode l1 = ListNode.createSinglyLinkedList(value_1);
            ListNode l2 = ListNode.createSinglyLinkedList(value_2);
            ListNode a = new Solution().addTwoNumbers(l1,l2);
            ListNode.printList(a);

        }
    }
}
