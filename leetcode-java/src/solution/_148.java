package solution;

import common.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class _148 {
    public ListNode sortList(ListNode head) {
        ListNode p = head;
        ListNode result = new ListNode(0);
        ListNode cur = result;

        ArrayList<Integer> nums = new ArrayList<>();
        while (p != null) {
            nums.add(p.val);
            p = p.next;
        }

        int gap = 1;
        while (gap < nums.size()) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i<nums.size(); i++) {
                int temp = nums.get(i);
                int j = i - gap;
                while (j >= 0 && nums.get(j) > temp) {
                    nums.set(j+gap, nums.get(j));
                    j -= gap;
                }
                nums.set(j+gap, temp);
            }
            gap = (int)Math.floor(gap/3);
        }
        for (int i = 0; i < nums.size(); i++) {
            ListNode next = new ListNode(nums.get(i));
            cur.next = next;
            cur = cur.next;
        }
       return result.next;
    }

    public static void main(String[] args) {
        ArrayList value = new ArrayList();
        value.add(3);
        value.add(2);
        value.add(4);
        value.add(6);
        value.add(5);
        value.add(1);
        value.add(7);
        value.add(8);
        ListNode head = ListNode.createSinglyLinkedList(value);
        ListNode result = new _148().sortList(head);
        ListNode.printList(result);
    }

}
