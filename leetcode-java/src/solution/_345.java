package solution;

public class _345 {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while (i < j) {
            while (i < j && !isVowels(sb.charAt(i))) {
                i++;
            }
            while (j > 0 && !isVowels(sb.charAt(j))) {
                j--;
            }
            if (i < j) {
                swap(sb, i, j);
                i++;
                j--;
            }
        }
        return sb.toString();
    }
    public void swap(StringBuilder sb, int i, int j) {

        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
    public boolean isVowels(char c) {
        if (c == 'a' || c =='e' || c == 'i' || c=='o' || c== 'u'||c=='A' || c == 'E' || c=='I'||c=='O'||c=='U'){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "leetcode";
        String res = new _345().reverseVowels(s);
        System.out.println(res);

    }
}
