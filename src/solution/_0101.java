package solution;

import java.util.Arrays;

public class _0101 {
    public boolean isUnique(String astr) {
        char[] str = astr.toCharArray();
        Arrays.sort(str);
        for (char i = 1; i < str.length; i++) {
            if (str[i] == str[i-1])
                return false;
        }
        return true;

    }
    public static void main(String [] args) {
        String s = "abc";
        boolean res = new _0101().isUnique(s);
        System.out.println(res);
    }
}
