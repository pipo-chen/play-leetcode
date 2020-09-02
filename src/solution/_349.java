package solution;

import java.util.*;

public class _349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int [] res = new int[Math.min(len1, len2)];
        quick_sort(nums1, 0 , len1 -1 );
        quick_sort(nums2, 0, len2 - 1);
        //双指针
        int i = 0, j = 0,index = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j] && i < len1 - 1)
                i++;

            if (nums1[i] == nums2[j] && index == 0)
                res[index++] = nums2[j++];

            if (nums1[i] == nums2[j] && index > 0 && res[index-1] != nums2[j]) {
                res[index++] = nums2[j++];
            }
        }
        return Arrays.copyOf(res, index);
    }
    //先两数组进行排序
    public void quick_sort(int[] nums, int left, int right) {
        if (left > right)
            return;
        int i = left, j = right, base = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= base)
                j--;
            while (i < j && nums[i] <= base)
                i++;
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = base;
        quick_sort(nums, left, i-1);
        quick_sort(nums, i + 1, right);
    }

    public static void main(String[] args) {
        int [] nums1 = {1,2,3};
        int [] nums2 = {1,3};
        int [] res = new _349().intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
