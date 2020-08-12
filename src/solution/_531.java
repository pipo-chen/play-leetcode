package solution;

public class _531 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (nums == null)
            return 0;
        if (nums.length == 1)
            return nums[0] == target ? 1 : 0;

       //开始搜索
        while (left <= nums.length - 1 && nums[left] < target) {
            left ++;
        }
        while (right >= 0 && nums[right] > target) {
            right--;
        }
        if (right < left) {
            return 0;
        } else {
            return  right - left + 1;
        }
        //如果等于的话 有两种情况 1 长度就是为 1 2. 有数据

    }

    public int search_original(int[] nums, int target) {
        int count = 0;
        for (int x : nums) {
            if (x == target)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int [] nums = {1};
        int target = 4;
        int res = new _531().search(nums, target);
        System.out.println(res);
    }
}
