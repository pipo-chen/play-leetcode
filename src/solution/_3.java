package solution;

import java.util.HashMap;
import java.util.Map;

//待优化
public class _3 {
	public int lengthOfLongestSubstring(String s) {
		int start = 0;
		int end = 0;
		int maxLen = 0;
		Map map = new HashMap<>();
		while (end < s.length()) {
			char cur = s.charAt(end);
			if (map.containsKey(cur)) {
				int index = (int)map.get(cur) + 1;
				if (index > start) {
					start = index;
				}
				//start 变更 但是 也要比当前的start大
			}
			map.put(cur, end);
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
