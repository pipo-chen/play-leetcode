package solution;

public class _713 {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k < 1 )
			return 0;
		int ans = 0, left = 0, multi = 1;
		for (int right = 0; right < nums.length; right++) {
			multi *= nums[right];
			while (multi >= k)
				multi /= nums[left++];
			ans += right - left + 1;
		}

		return ans;
    }
    public static void main(String [] args) {
		int [] nums = {10,5,2,6};
		int k = 100;
		int res = new _713().numSubarrayProductLessThanK(nums, k);
		System.out.println(res);
	}
}
