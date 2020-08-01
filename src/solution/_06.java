package solution;

import common.ListNode;

import java.util.ArrayList;


public class _06 {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        int total = values.size();
        int[] nums = new int[total];
        int count = 0;
        for (int i = total - 1; i >= 0; i--) {
            nums[count++] = values.get(i);
        }
        return nums;
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
