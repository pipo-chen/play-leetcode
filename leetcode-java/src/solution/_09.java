package solution;

public class _09 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;

    }
    public static void main(String[] args) {
        int x = 11;
        boolean res = new _09().isPalindrome(x);
        System.out.println(res);

    }
}
