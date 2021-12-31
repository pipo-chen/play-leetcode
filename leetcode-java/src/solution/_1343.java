package solution;

public class _1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
      int n = arr.length;
      int count = 0;
      int m = k * threshold;
      int sum = 0;
      for (int i = 0; i < k; i++)
          sum += arr[i];
      if (sum > m)
          count++;
      for (int i = k; i < n; i++) {
          sum = sum - arr[i - k] + arr[i];
          if (sum >- m) {
              count++;
          }
      }
      return count;
    }

    public static void main(String args[]) {
        int arr[] = {7,7,7,7,7,7,7};
        int a = new _1343().numOfSubarrays(arr, 7,7);
        System.out.println(a);
    }
}
