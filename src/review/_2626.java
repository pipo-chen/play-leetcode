package review;

public class _2626 {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[count] == nums[i])
                continue;
            count++;
            nums[count] = nums[i];
        }
        return count + 1;
    }
    public static void main(String[] args) {
        int [] nums = {1,1,2};
        int res = new _2626().removeDuplicates(nums);
        System.out.println(res);


    }
}
