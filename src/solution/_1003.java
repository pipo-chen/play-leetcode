package solution;

/**
 * abc 是有效字符串
 * 在一个有效字符串的任意位置插入abc得到的字符串是有效字符串
 * 注意审题：原来是消消乐..
 * @return
 */
public class _1003 {

    public boolean isValid(String s) {
        while (s.contains("abc")) {
            s = s.replaceAll("abc","");
        }

        return s.equals("");
    }

    public static void main(String[] args) {
        String s = "abacbabcc";
        boolean res = new _1003().isValid(s);
        System.out.println(res);
    }

}
