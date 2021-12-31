package solution;

public class _0109 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        s1 += s1;

        return s1.contains(s2);
    }
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        boolean res = new _0109().isFlipedString(s1, s2);
        System.out.println(res);
    }
}
