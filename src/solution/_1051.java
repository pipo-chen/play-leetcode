package solution;

public class _1051 {
    public int heightChecker(int[] heights) {
        //桶排序
        int [] bucket = new int[101];
        for (int x : heights) {
            bucket[x] ++;
        }
        int j = 0;
        int count = 0;
        for (int i = 0; i < bucket.length && j < heights.length; i++) {
            while (bucket[i] != 0) {
                //比较该位置的 heights 不管是否相等 j 都应该进一位
                //还得循环同一位置上的[]
                if (heights[j] != i) {
                   count++;
                }
                j++;
                bucket[i]--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] heights = {2,1,2,1,1,2,2,1};
        int res = new _1051().heightChecker(heights);
        System.out.println(res);
    }
}
