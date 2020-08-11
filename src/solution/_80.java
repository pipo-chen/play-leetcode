package solution;

public class _80 {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                count++;
            } else {
                count = 0;
            }
            if (count < 2) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,3};
        int len = new _80().removeDuplicates(nums);
        System.out.println(len);
    }
}
