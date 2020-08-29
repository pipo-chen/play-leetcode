package solution;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class _1606 {
    public int smallestDifference(int[] a, int[] b) {
        quick_sort(a, 0, a.length - 1);
        quick_sort(b, 0, b.length - 1);
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            long diff = Math.abs((long)a[i] - b[j]);
            min = (int)Math.min(min, diff);
            if (min == 0)
                return 0;
            if (a[i] < b[j] )
                i++;
            else
                j++;
        }
        return min;
    }

    public static void quick_sort(int []nums, int left, int right) {
        if (left > right)
            return;
        int i = left, j = right, base = nums[left];
        while (i < j) {
            while (nums[j] >= base && i < j)
                j--;
            while (nums[i] <= base && i < j)
                i++;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[left] = nums[i];
        nums[i] = base;
        quick_sort(nums, left, i - 1);
        quick_sort(nums, i + 1, right);
    }

    public static void main(String[] args) {
        int [] a = {-2147483648,1};
        int [] b = {2147483647,0};
        int res = new _1606().smallestDifference(a, b);
        System.out.println(res);
    }
}
