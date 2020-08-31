package solution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList();
        int [] pfreq = new int[128];

        for (int i = 0; i < p.length(); i++) {
            pfreq[p.charAt(i)]++;
        }

        int [] sfreq = new int[128];
        int left = 0, right = -1, distance = 0;
        char[] arr = s.toCharArray();
        while (left < arr.length) {
            if (right < arr.length - 1 && sfreq[arr[right+1]] <= pfreq[arr[right + 1]]) {
                sfreq[arr[++right]]++;
            } else {
                sfreq[arr[left++]]--;
            }
            //相同的字符个数 如果每个都相同再记录
            boolean flag = true;
            for (int i = 0; i < p.length(); i++) {
                if (pfreq[p.charAt(i)] != sfreq[p.charAt(i)]) {
                    flag = false;
                }
            }
            if (flag) {
                //记录
                res.add(left);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List res = new _438().findAnagrams(s, p);
        Iterator iterator = res.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
