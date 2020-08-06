package solution;

public class _1051 {
    public int heightChecker(int[] heights) {
        int [] result = new int[heights.length];
        //对 heights 进行排序
        for (int i = 0; i < heights.length; i++) {
            result[i] = heights[i];
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                if (heights[i] > heights[j]) {
                    int temp = heights[i];
                    heights[i] = heights[j];
                    heights[j] = temp;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != result[i])
                count++;
        }

        return count;
    }
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        int res = new _1051().heightChecker(heights);
        System.out.println(res);
    }
}
