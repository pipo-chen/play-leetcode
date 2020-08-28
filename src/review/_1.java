package review;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1 {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i],i);
		}
		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			//并且这个不能与当前的 i 相等
			int another = target - x;
			if (map.containsKey(another) && map.get(another) != i) {
				return new int[]{i, map.get(another)};
			}
		}
		return new int[]{-1,-1};
    }

    public static void main(String[] args) {
		int [] nums = {2,7,11,15};
		int target = 9;
		int [] res = new _1().twoSum(nums, target);
		System.out.println(Arrays.toString(res));

	}
}
