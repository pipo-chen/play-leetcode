package solution;

import java.util.HashMap;
import java.util.Map;

public class _3 {
	public int lengthOfLongestSubstring(String s) {
		int start = 0;
		int end = 0;
		int maxLen = 0;
		Map map = new HashMap<>();
		while (end < s.length()) {
			char cur = s.charAt(end);
			if (!map.containsKey(cur)) {
				map.put(cur, end);
			} else {
				int index = (int)map.get(cur) + 1;
				if (index > start) {
					start = index;
				}
				map.put(cur, end);
				//start 变更 但是 也要比当前的start大
			}
			maxLen = Math.max(end - start + 1, maxLen);
			end++;

		}
		return maxLen;

    }
    public static void main(String[] args) {
		String s = "aabaab!bb";
		int res = new _3().lengthOfLongestSubstring(s);
		System.out.println(res);
	}
}
