package solution;

public class _0103 {
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char cur = S.charAt(i);
            if (cur == ' ') {
                //如果是空格
                sb.append("%20");
            } else {
                sb.append(cur);
            }
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        String s1 = "Mr John Smith    ";
        int length = 13;
        String res = new _0103().replaceSpaces(s1, length);
        System.out.print(res+"/");
    }
}
