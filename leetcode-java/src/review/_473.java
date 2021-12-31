package review;

public class _473 {
    public static boolean makesquare(int[] nums) {
        //先排除基本不可能的情况
        if (nums.length < 4)
            return false;

        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % 4 != 0)
            return false;

        int border = sum / 4;

        //希尔排序
        int j = 0;
        int temp = 0;
        for (int increament = nums.length / 2; increament > 0; increament /= 2) {
            for (int i = increament; i < nums.length; i++) {
                temp = nums[i];
                for (j = i - increament; j >= 0; j -= increament) {
                    if (temp > nums[j])
                        nums[j + increament] = nums[j];
                    else
                        break;
                }
                nums[j + increament] = temp;
            }
        }
        //装入桶
        int[] bucket = {0,0,0,0};

        return generateBucket(0,bucket, border, nums);
    }

    private static boolean generateBucket( int i, int[] bucket, int target, int[] nums) {
        if (i == nums.length) {
            return bucket[0] == target && bucket[1] == target && bucket[2] == target && bucket[3] == target;
        }
        for (int j = 0; j < bucket.length; j++) {
            if (bucket[j] + nums[i] > target)
                continue;
            bucket[j] += nums[i];
            if (generateBucket(i+1,bucket,target,nums))
                return true;
            else
                bucket[j] -= nums[i];
        }

        return false;
    }

    public static void main(String[] args) {
        int [] nums = {3,3,3,3,4,4,4,4,5,5,5,5};
         boolean res = _473.makesquare(nums);
         System.out.println(res);
    }
}
