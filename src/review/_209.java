package review;

public class _209 {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = -1;
        int minLen = nums.length + 1;
        int sum = 0;


        while (end < nums.length && start < nums.length) {
            if (end < nums.length - 1 && sum < s) {
                sum += nums[++end];
            } else {
                sum -= nums[start++];
            }

            if (sum >= s) {
                minLen = Math.min(minLen, end - start + 1);
            }

        }
        if (minLen == nums.length + 1)
            return 0;
        return minLen;
    }
    public static void main(String[] args) {
        int [] nums = {1,1};
        int res = new _209().minSubArrayLen(3, nums);
        System.out.println(res);
    }
}
