package review;

public class _215 {
    public int findKthLargest(int[] nums, int k) {
        quick_sort(nums, 0, nums.length - 1, k);
        return nums[k-1];
    }

    public void quick_sort(int[] nums, int left, int right, int k) {

        if (left > right)
            return;
        int i = left, j = right, base = nums[left];
        while (i < j) {
            while (nums[j] <= base && i <j) {
                j--;
            }
            while (nums[i] >= base && i < j) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = base;
        quick_sort(nums, left, i - 1, k);
        quick_sort(nums, i + 1, right, k);

    }

    public static void main(String[] args) {
        int [] nums = {3,2,1,5,6,4};
        int k = 2;
        int res = new _215().findKthLargest(nums, k);
        System.out.println(res);
    }
}
