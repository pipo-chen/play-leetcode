package solution;

public class _531 {
    public int search(int[] nums, int target) {
        int count = 0;
        for (int x : nums) {
            if (x == target)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int target = 8;
        int res = new _531().search(nums, target);
        System.out.println(res);
    }
}
