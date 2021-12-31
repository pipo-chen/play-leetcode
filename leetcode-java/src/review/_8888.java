package review;

import java.util.Arrays;

public class _8888 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m + n - 1;
        int i = n - 1;
        int k = m - 1;
        while (j >= 0 && i >= 0) {
            if (k>=0 && nums1[k] > nums2[i])
                nums1[j--] = nums1[k--];
            else
                nums1[j--] = nums2[i--];
        }
        System.out.println(Arrays.toString(nums1));
    }
    public static void main(String[] args) {
        int []nums1 = {0};
        int [] nums2 = {4};
        int m = 0;
        int n = 1;
        new _8888().merge(nums1, m, nums2, n);
    }
    
}
