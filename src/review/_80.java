package review;

public class _80 {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1, count = 0;
        while (j < nums.length) {
            //判断 j 以及 count 次数
            if (nums[j] == nums[i] && count < 1) {
                nums[++i] = nums[j];
                count++;
            } else if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
                count = 0;
            }
            j++;

        }

        return i+1;
    }
    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,1,2,3,3};
        int res = new _80().removeDuplicates(nums);
        System.out.println(res);
    }
}
