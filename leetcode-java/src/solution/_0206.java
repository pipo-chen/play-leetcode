package solution;

import common.ListNode;

import java.util.ArrayList;

public class _0206 {
    public boolean isPalindrome(ListNode head) {
        ListNode reverse = null;
        ListNode cur = head;
        while (cur != null) {
            //倒着插入
            ListNode temp = new ListNode(cur.val);
            temp.next = reverse;
            reverse = temp;
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList nums = new ArrayList();
        nums.add(1);
        nums.add(2);
        nums.add(1);
        ListNode node = ListNode.createSinglyLinkedList(nums);
        boolean res = new _0206().isPalindrome(node);
        System.out.println(res);
    }

}
