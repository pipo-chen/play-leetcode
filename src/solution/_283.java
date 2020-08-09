package solution;

public class _283 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length && i < nums.length) {
            while (nums[i] != 0)
                i++;
            j = i + 1;
            while ( j <nums.length && nums[j] == 0)
                j++;

            if (j < nums.length) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }

        for (int n : nums)
            System.out.print(n+" ");

    }
    public static void main(String[] args) {
        int [] nums = {0,1,0,3,12};
        new _283().moveZeroes(nums);
    }
}
