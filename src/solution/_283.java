package solution;

public class _283 {
    public void moveZeroes(int[] nums) {
        int zero = 0;
        for (int x : nums) {
            if (x != 0) {
                nums[zero] = x;
                zero++;
            }
        }
        while (zero < nums.length) {
            nums[zero] = 0;
            zero++;
        }

        for (int n : nums)
            System.out.print(n+" ");

    }
    public static void main(String[] args) {
        int [] nums = {0,1,0,3,12};
        new _283().moveZeroes(nums);
    }
}
