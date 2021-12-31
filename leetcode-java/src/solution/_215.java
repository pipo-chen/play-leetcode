package solution;

import java.util.Arrays;

public class _215 {

    public int findKthLargest(int [] nums, int k) {

        quickSock(nums,0, nums.length -1);
        return nums[k-1];
    }

    public void quickSock(int [] nums, int low, int high) {
        if (low >= high)
            return;
        int i = low, j = high, base = nums[low];
        while (i < j) {
            while (nums[j] <= base && i < j)
                j--;
            while (nums[i] >= base && i < j)
                i++;
            swap(nums, i, j);
        }
        swap(nums, low, j);
        quickSock(nums, low, j - 1);
        quickSock(nums, j + 1, high);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int k = 2;
        int [] nums = {3,2,1,5,6,4};
        int res = new _215().findKthLargest( nums, k);
        System.out.println(res);
    }
}
