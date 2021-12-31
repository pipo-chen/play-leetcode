package solution;

public class _162 {
    public int findPeakElement(int[] nums) {
        if (nums.length < 2)
            return 0;
        //比较中间
        for (int i = 1; i <nums.length-1; i++) {
            if (nums[i] > nums[i + 1] && nums[i] > nums[i-1]) {
                return i;
            }
        }
        return nums[nums.length - 1] > nums[nums.length - 2] ? nums.length - 1 : 0;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int res = new _162().findPeakElement(nums);
        System.out.println(res);
    }

}
