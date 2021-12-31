package solution;

public class _5353 {
    public int maxSubArray(int[] nums) {
        //至少包含一个元素
        int sum = nums[0];
        // 记录 maxSum
        int maxSum = sum;
        for (int i = 1; i < nums.length; i++) {
            int data = nums[i];
            sum = sum + data;
            if (data >= sum) {
                sum = data;
            }
            if (maxSum < sum)
                maxSum = sum;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int [] nums = {-1,2,1,4,5};
        int res = new _5353().maxSubArray(nums);

        System.out.println(res);
    }
}
