package solution;

public class _53 {
    public int missingNumber(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                flag = true;
                return i;
            }
        }
        return flag ? -1 : nums.length;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,7,8};
        int miss = new _53().missingNumber(nums);
        System.out.println(miss);
    }
}
