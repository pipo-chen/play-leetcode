package solution;

import common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class _1019 {
    public int[] nextLargerNodes(ListNode head) {
        //1. 先把 head 存在 list 里面 如果是数组的话 就开辟固定空间
        ArrayList<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        //2. 创建一个空的单调栈
        Stack<Integer> monotonous = new Stack<>();
        //3. 如果这个列表长度不为空的情况下，判断入栈
        for (int i = 0; i<nums.size();i++) {
            int value = nums.get(i);
            if (monotonous.isEmpty()) {
                monotonous.push(i);
                continue;
            }
            while (!monotonous.isEmpty() && value > nums.get(monotonous.peek())) {
                nums.set(monotonous.peek(), value);
                monotonous.pop();
            }
            monotonous.push(i);
        }
        //4. 栈中剩余的元素全部置 0
        while (!monotonous.empty()) {
            nums.set(monotonous.peek(), 0);
            monotonous.pop();
        }
        //返回数组
        int[] res = new int[nums.size()];
        for (int i = 0; i <nums.size(); i++) {
            res[i] = nums.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
        ArrayList value = new ArrayList();
        value.add(2);
        value.add(7);
        value.add(4);
        value.add(3);
        value.add(5);
        ListNode head = ListNode.createSinglyLinkedList(value);
        int []a= new _1019().nextLargerNodes(head);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }
}
