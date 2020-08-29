package review;

public class _209_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length + 1;
        int left = 0, right = 0, sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
                len = Math.min(len, right - left);
                sum -= nums[left++];
            }
        }
        return len == nums.length + 1 ? 0 : len;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int s = 7;
        int res = new _209_209().minSubArrayLen(s, nums);
        System.out.println(res);
    }
}
