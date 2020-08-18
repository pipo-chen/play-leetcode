package solution;

import java.util.Arrays;

public class _0102 {
    public boolean CheckPermutation(String s1, String s2) {
        //排序
        if (s1.length() != s2.length())
            return false;
        char []c1 = s1.toCharArray();
        char []c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        //比较
        int i = c1.length - 1;
        int j = c2.length - 1;
        while (i >= 0) {
            if (c1[i--] != c2[j--])
                return false;
        }
        return true;
    }
    public static void main(String [] args) {
        String s1 = "abc";
        String s2 = "bcb";
        boolean res = new _0102().CheckPermutation(s1, s2);
        System.out.println(res);
    }
}
