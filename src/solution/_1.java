package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i],i);

        System.out.println(map.toString());
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x)) {
                //经典！如果 重复的元素，就遍历 i 与之匹配到不同的下标即可
                if (map.get(target - x) != i)
                    return new int[] {i,map.get(target-x)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int [] nums = {3,3,4};
        int target = 6;
        int [] res = new _1().twoSum(nums,target);
        System.out.println(Arrays.toString(res));
    }

}
