package review;

public class _26 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
    public static void main(String[] args) {
        //原地删除重复的数组，数组已排序
        int []nums = {0,0,1,1,1,2,2,3,3,4};
        int res = new _26().removeDuplicates(nums);
        System.out.println(res);
    }
}
