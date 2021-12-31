package solution;

import java.util.Arrays;

public class _1144 {
    int len;
    public int movesToMakeZigzag(int[] nums) {
        len = nums.length;
        return countNumsGap(nums, 0) ;
    }

    private int countNumsGap(int[] arr, int index) {
        int count = 0;
        for (;index < len; index +=2) {
            if (index < len-1 && arr[index] <= arr[index + 1]) {
                count += arr[index + 1] - arr[index] + 1;
                arr[index + 1] = arr[index] - 1;
            }
            if (index > 0 && arr[index] <= arr[index - 1]) {
                count += arr[index - 1] - arr[index] + 1;
                arr[index - 1] = arr[index] - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int []nums = {7,4,8,9,7,7,5};
        int result = new _1144().movesToMakeZigzag(nums);
        System.out.println(result);
    }

}
