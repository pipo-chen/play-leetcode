package solution;

import common.ListNode;

import java.util.ArrayList;

public class _817 {
    public int numComponents(ListNode head, int[] G) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> common = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < G.length; i++) {
            list.add(G[i]);
        }
        while (head != null) {
            if (list.contains(head.val)) {
                list.remove((Object)head.val);
                common.add(head.val);
            } else {
                //有可能此时链表已空
                if (list.isEmpty())
                    break;
                if (!common.isEmpty()) {
                    count ++;
                    common.clear();
                }
            }
            head = head.next;
        }
        //遍历完之后善后
        if (!common.isEmpty())
            count++;

        return count;
    }
    public static void main(String[] args) {
        ArrayList value = new ArrayList();
        value.add(0);
        value.add(1);
        value.add(2);
        value.add(3);
        int[] G = {0,1,3};
        ListNode l = ListNode.createSinglyLinkedList(value);
        int res = new _817().numComponents(l, G);
        System.out.println(res);
    }
}
