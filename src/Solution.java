import java.lang.reflect.Array;
/**
 *  //数组排序 -> 计算第一个平均超过 指定数值
 *         int length = arr.length;
 *         int incrementNum = length/2;
 *         while (incrementNum > 0){
 *             for(int i = incrementNum ;i<length;i++){
 *                 int j =i - incrementNum;
 *                 while (j >= 0 && arr[j] > arr[j+incrementNum]) {
 *                     int temp = arr[j+incrementNum];
 *                     arr[j+incrementNum] = arr[j];
 *                     arr[j] = temp;
 *                     j = j - incrementNum;
 *                 }
 *             }
 *             incrementNum = incrementNum /2;
 *         }
 *         int i= 0;
 *         while (i+k<length) {
 *             int sum = 0;
 *             for (int j = i;j<i+k;j++) {
 *                 sum += arr[j];
 *             }
 *             float avg = sum / k;
 *             System.out.println("avg="+avg);
 *             if (avg < threshold) {
 *                 i++;
 *             } else {
 *                 return length - k - i + 1;
 *             }
 *         }
 *         return 0;
 * */
public class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i =0;
        int count = 0;
        while (i+k <= arr.length) {
            //计算i->k
            int sum = 0;
            for (int j = i;j < i+k;j++) {
                sum += arr[j];
            }
            float avg = sum / k;
            if (avg >= threshold)
                count++;
            i++;
        }
        return count;
    }

    public static void main(String args[]) {
        int arr[] = {7,7,7,7,7,7,7};
        int a = new Solution().numOfSubarrays(arr, 7,7);
        System.out.println(a);
    }
}
