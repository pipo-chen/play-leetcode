package solution;


public class _27 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int x : nums) {
            if (x != val) {
                nums[count ++] = x ;
            }
        }

        for (int i = 0; i < count; i++)
            System.out.println(nums[i]);
        return count;

    }
    public static void main(String[] arsg) {
        int [] nums = {3,2,2,3};
        int val = 2;
        int res = new _27().removeElement(nums, val);
        System.out.println(res);
    }
}
