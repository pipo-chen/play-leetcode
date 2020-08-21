package review;

import java.util.HashMap;
import java.util.Map;

public class _3 {
    public int lengthOfLongestSubstring(String s) {
        int start = 0,end = 0,len = 0;
        Map map = new HashMap();
        while (end < s.length()) {
            char cur = s.charAt(end);
            //移动start的条件
            if (map.containsKey(cur)) {
                start = Math.max(start, (int)map.get(cur) + 1);
            }
            len = Math.max(end - start + 1, len);
            map.put(cur, end);
            end++;
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "  ";
        int res = new _3().lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
