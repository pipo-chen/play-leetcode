package solution;

public class _16 {
	public int threeSumClosest(int[] nums, int target) {
		int len = nums.length;
		quick_sort(nums, 0 , len - 1);
		if (len < 3)
			return 0;
		int ans = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < len - 1; i++) {
			int start = i + 1;
			int end = len - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				ans = Math.abs(target - sum) < Math.abs(target - ans) ? sum : ans;
				if (sum < target)
					start++;
				else
					end--;
			}
		}
		return ans;
    }
    public static void quick_sort(int[] nums, int left, int right) {
		if (left > right)
			return;
		int i = left, j = right, base = nums[left];

		while (i < j) {
			while (nums[j] >= base && i < j)
				j--;
			while (nums[i] <= base && i < j)
				i++;
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		nums[left] = nums[i];
		nums[i] = base;
		quick_sort(nums, left, i - 1);
		quick_sort(nums, i + 1, right);
	}

    public static void main(String[] args) {
		int [] nums = {-1,2,3,4,5,6,7,8,82,34,2,23};
		int target = 30;
		int res = new _16().threeSumClosest(nums, target);
		System.out.println(res);

	}

}
