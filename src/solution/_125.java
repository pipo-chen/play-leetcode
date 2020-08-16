package solution;

import javax.xml.stream.events.Characters;

public class _125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < s.length() -1 && !isCharacter( s.charAt(i)) ) {
                i++;
            }
            while (j > 0 && !isCharacter( s.charAt(j)) ) {
                j--;
            }

            if (i < j && ! (s.charAt(i) ==  s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isCharacter(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <='Z' || c >= '0' && c <= '9')
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "0P";
        boolean res = new _125().isPalindrome(s);
        System.out.println(res);
    }
}
