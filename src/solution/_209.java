package solution;

public class _209 {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                //在这里比较
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }
    public static void main(String[] args) {
        int[] nums = {1,4,4};
        int s = 4;
        int res = new _209().minSubArrayLen(s, nums);
        System.out.println(res);
    }
}
