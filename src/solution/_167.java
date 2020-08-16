package solution;

import java.util.Arrays;

public class _167 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] > target && j >= 0) {
                j--;
            } else if (numbers[i] + numbers[j] < target && i < numbers.length){
                i++;
            } else {
                return new int[]{i+1,j+1};
            }
        }
        return new int[] {0,0};
    }
    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;
        int [] res = new _167().twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
