package solution;

public class _1003 {
    /**
     * abc 是有效字符串
     * 在一个有效字符串的任意位置插入abc得到的字符串是有效字符串
     * 注意审题：原来是消消乐..
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        String compare = "abc";
        if (repeat((s.length()/compare.length()), compare).equals(s))
            return true;

        if (s.substring(1, s.length() - 1).contains(compare))
            return true;

        return false;
    }

    public static String repeat(int num, String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abacbabcc";
        boolean res = new _1003().isValid(s);
        System.out.println(res);

    }
//    "abcabc"
//    "abacbabcc"
}
