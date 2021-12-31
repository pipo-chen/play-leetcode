package solution;

public class _394 {
    public String decodeString(String s) {
        //读取到数字之后 读取左括号和右括号内的字符串
        for (int i = 1; i < s.length();i++){
            char cur = s.charAt(i);
            String inner = "";
            if (cur == '[') {
                while (cur != ']') {
                    if (i < s.length() - 1 ) {
                        inner += cur;
                        cur = s.charAt(++i);
                    }
                    else
                        break;
                }
                System.out.println(inner);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "3[a2[bc]]";
        String res = new _394().decodeString(s);

    }

}
