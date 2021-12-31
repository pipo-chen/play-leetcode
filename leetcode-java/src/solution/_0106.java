package solution;

public class _0106 {
    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        if (S.length() <= 1)
            return S;
        for (int i = 1; i <= S.length(); i++) {

            if (i < S.length() && S.charAt(i) == S.charAt(i-1)) {
                count++;
                continue;
            }
            sb.append(S.charAt(i-1));
            sb.append(count);
            count = 1;
        }

        //压缩
        return sb.length() < S.length() ?  sb.toString() : S;
    }
    public static void main(String[] args) {
        String s = "bbbac";
        String res = new _0106().compressString(s);
        System.out.println(res);
    }

}
