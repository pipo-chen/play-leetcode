package solution;

public class _473 {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4)
            return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 4 != 0)
            return false;

        int avg = sum / 4;

        //寻找边相加等于 avg 数组排序
        int j = 0;
        int temp = 0;
        for (int increament = nums.length /2; increament > 0; increament /=2) {
            for (int i = increament; i <nums.length; i++) {
                temp = nums[i];
                for (j = i - increament; j>=0; j -= increament) {
                    if (temp > nums[j])
                        nums[j + increament] = nums[j];
                    else
                        break;
                }
                nums[j + increament] = temp;
            }
        }
        int[] bucket = {0,0,0,0};
        return generate(0, nums,avg,bucket);
    }
    private static boolean generate(int i, int[] nums, int target, int[] bucket) {
        if (i >= nums.length)
            return bucket[0] == target && bucket[1] == target && bucket[2] == target && bucket[3] == target;
        for (int j = 0; j<4;j++) {
            if ( bucket[j] + nums[i] > target)
                continue;
            bucket[j] += nums[i];
            if (generate(i+1, nums, target, bucket))
                return true;
            //如果失败了 则回溯到这一步
            bucket[j] -= nums[i];
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {5,5,5,5,4,4,4,4,3,3,3,3};
        boolean result = new _473().makesquare(nums);
        System.out.println(result);
    }

}
