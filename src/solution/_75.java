package solution;

import java.util.Arrays;

public class _75 {
    public void sortColors(int[] nums) {
        int [] count = new int[3];
        for (int x : nums) {
            count[x]++;
        }
        int j = 0;
        for (int i = 0; i <nums.length;i++) {
            while (count[j] == 0)
                j++;
            nums[i] = j;
            count[j]--;
        }

        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        int [] nums = {2,0,2,1,1,0};
        new _75().sortColors(nums);
    }
}
