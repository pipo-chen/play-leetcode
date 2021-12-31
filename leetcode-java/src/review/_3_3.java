package review;

import java.util.TreeSet;

public class _3_3 {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[122];
        int l = 0, r = -1, res = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && count[s.charAt(r + 1)] == 0)
                count[s.charAt(++r)]++;
            else
                count[s.charAt(l++)]--;
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        int res = new _3_3().lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
