package solution;

import java.util.HashMap;
import java.util.Map;

public class _1528 {
    public String restoreString(String s, int[] indices) {
        char[] result = new char[indices.length];
        for (int i = 0;i<indices.length;i++) {
            result[indices[i]] = s.charAt(i);
        }

        return String.valueOf(result);
    }
    public static void main (String[] args) {
        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        String result = new _1528().restoreString(s, indices);
        System.out.println(result);
    }

    private String method_2(String s, int[] indices) {
        String result = "";
        HashMap<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(indices[i], s.charAt(i));
        }
        for (int i = 0; i<s.length();i++) {
            result +=map.get(i);
        }

        return result;
    }
}
