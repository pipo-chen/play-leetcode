package solution;

import java.util.*;

public class _49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		List group = new ArrayList();
		Map<String, List<String>> map = new HashMap();

		for (String s : strs) {
			char[] res = s.toCharArray();
			Arrays.sort(res);
			String key = String.valueOf(res);

			//判断是否包含该key
			if(map.containsKey(key)) {
				map.get(key).add(s);

			} else {
				List<String> sameList = new ArrayList<>();
				sameList.add(s);
				map.put(key, sameList);
			}
		}
		for(Map.Entry entry : map.entrySet()) {
			group.add(entry.getValue());
		}

		return group;
	}
	public static void main(String[] args) {
		String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = new _49().groupAnagrams(str);

	}
}
