package solution;

import java.util.Arrays;

public class _0104 {
    public boolean canPermutePalindrome(String s) {
        //如果是偶数长度 每个字母都需要出现 2 次 奇数长度 可以有一个是 奇数次
        //只要奇数个数 小于等于 0 个
        char [] c = s.toCharArray();
        Arrays.sort(c);
        int odd = 0;
        int count = 1;
        if (s.length() <= 1)
            return true;

        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length()  && c[i] == c[i-1]) {
                count++;
                continue;
            }
            if (count % 2 != 0)
                odd++;
            if (odd > 1)
                return false;
            count = 1;
        }
        return odd <= 1 ? true : false;
    }
    public static void main(String[] args) {
        String s = "code";
        boolean res = new _0104().canPermutePalindrome(s);
        System.out.println(res);
    }
}
