package review;

public class _8080 {
    public int removeDuplicates(int[] nums) {
       int count = 0;
       int j = 1;
       for (int i = 1; i <nums.length; i++) {
           if (nums[i] == nums[i-1])
               count++;
           else
               count = 0;

           //只要考虑覆盖的情况就好了
           if (count < 2) {
               nums[j] = nums[i];
               j++;
           }
       }
       return j;

    }
    public static void main(String [] args) {
        int [] nums = {0,0,1,1,1,1,2,3,3};
        int res = new _8080().removeDuplicates(nums);
        System.out.println(res);
    }
}
