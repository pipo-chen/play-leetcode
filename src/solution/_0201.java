package solution;

import common.ListNode;

import java.util.*;

public class _0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        //先进行一遍统计
        ListNode cur = head;
        ArrayList list = new ArrayList();
        while (cur != null) {
            int val = cur.val;
            if (!list.contains(val))
                list.add(val);
            cur = cur.next;
        }

        ListNode dummyHead = new ListNode(88);
        cur = dummyHead;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            int data = (int)iterator.next();
            ListNode temp = new ListNode(data);
            cur.next = temp;
            cur = cur.next;
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {
        ArrayList nums = new ArrayList();
        nums.add(4);
        nums.add(2);
        nums.add(3);
        nums.add(3);
        nums.add(2);
        nums.add(1);
        ListNode node = ListNode.createSinglyLinkedList(nums);
        ListNode res = new _0201().removeDuplicateNodes(node);
        ListNode.printList(res);
    }
}
