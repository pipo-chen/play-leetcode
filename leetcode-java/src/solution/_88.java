package solution;

public class _88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int tail = m + n - 1;
        int p2 = n-1;
        while (tail >= 0 && p2 >= 0) {
            int v2 = nums2[p2];
            int v1 = p1 >= 0 ? nums1[p1] : v2-1;
            if (v1 < v2) {
                nums1[tail] = v2;
                tail--;
                p2--;
            } else {
                nums1[tail] = v1;
                tail--;
                p1--;
            }
        }
        for (int x : nums1)
            System.out.print(x+"  ");
        System.out.println();
    }
    public static void main(String[] args) {
        int [] nums1 = {0};
        int [] nums2 = {1};
        int m = 0;
        int n = 1;
        new _88().merge(nums1, m, nums2, n);
    }
}
