package solution;

import java.util.Arrays;

public class _34 {
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[]{-1,-1};
        int begin = 0;
        int tail = nums.length - 1;
        while (begin <= tail) {
            while (target < nums[tail])
                tail--;
            while (target > nums[begin])
                begin++;

            //判断是否为target
            if (target == nums[begin])
                return new int[]{begin, tail};
            else
                return res;

        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums = {1};
        int target = 1;
        int [] res = new _34().searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
