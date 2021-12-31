package solution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _1441 {

    public List<String> buildArray(int[] target, int n) {

        List<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 1; count < target.length; i++) {
            if (target[count] > i) {
                list.add("Push");
                list.add("Pop");
            } else {
                list.add("Push");
                count++;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int [] target = {2,3,4};
        int n = 4;
        List<String> res = new _1441().buildArray(target, n);
        Iterator iterator = res.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
