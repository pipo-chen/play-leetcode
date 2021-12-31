package solution;

public class _26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int count = 1;
        // 快慢指针
        int j = 0;
        int i = 0;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
                continue;
            }
            //直到找到不想等时
            nums[++i] = nums[j];
            count++;
        }
        return count ;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1};
        int res = new _26().removeDuplicates(nums);
        System.out.println(res);
    }
}
