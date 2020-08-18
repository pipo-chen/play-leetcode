package solution;

import common.ListNode;

import java.util.*;

public class _0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        //先进行一遍统计
        ListNode cur = head;
        //无序的
        Set set = new HashSet();

        int count = 0;
        while (cur != null) {
            set.add(cur.val);
            cur = cur.next;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = null;
        cur = dummyHead;

        Iterator iterator = set.iterator();
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
        nums.add(1);
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
