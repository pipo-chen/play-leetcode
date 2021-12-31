package solution;

import java.util.Arrays;

public class _1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int j = m + n - 1;
        int i = m - 1;
        int k = n - 1;
        while (k >= 0 && j >=0 ) {
            int v2 = B[k];
            int v1 = i < 0 ? v2-1 : A[i];
            if (v1 > v2) {
                A[j] = v1;
                i--;
            } else {
                A[j] = v2;
                k--;
            }
            j--;
        }

    }
    public static void main(String[] args) {
        int [] A = {0};
        int [] B = {2};
        int m = 0;
        int n = 1;
        new _1001().merge(A,m,B,n);
        System.out.println(Arrays.toString(A));
    }
}
