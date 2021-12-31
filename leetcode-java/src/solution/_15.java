package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            //排除重复元素
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            //进入
            int target = -nums[i];
            int k = len-1;

            for (int j = i+1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j-1])
                    continue;
                //匹配 k
                while (j < k && nums[j] + nums[k] > target)
                    k--;
                //如果相同 break 掉
                if (j == k)
                    break;

                if (nums[j] + nums[k] == target) {
                    List temp = new ArrayList();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int [] nums = {0,0,0,0};
        List<List<Integer>> result = new _15().threeSum(nums);
        System.out.println(result.toString());
    }
}
