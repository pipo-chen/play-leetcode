package solution;

public class _11 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            //当前的面积
            int area = (j - i) * (Math.min(height[i],height[j]));
            if (height[i] < height[j])
                i++;
            else
                j--;
            max = Math.max(area, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        int res = new _11().maxArea(height);
        System.out.println(res);
    }
}
