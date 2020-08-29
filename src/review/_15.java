package review;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _15 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> group = new ArrayList();
		//要想不重复的话 必然先排序
		quick_sort(nums, 0 , nums.length - 1);

		int len = nums.length;

		for (int i = 0; i < len; i++) {

			if (i > 0 && nums[i] == nums[i-1])
				continue;

			int k = len - 1;

			for (int j = i + 1; j < len; j++) {

				if (j > i + 1 && nums[j] == nums[j-1])
					continue;

				while (k > j && nums[k] + nums[j] > -nums[i])
					k--;

				if (k == j)
					break;

				if (nums[k] + nums[j] == -nums[i]) {
					//记录
					List record = new ArrayList();
					record.add(nums[i]);
					record.add(nums[j]);
					record.add(nums[k]);
					group.add(record);
				}
			}
		}
		return group;
    }

    public static void quick_sort(int[] nums, int left, int right) {
		if (left > right)
			return;
		int i = left, j = right;
		int base = nums[left];

		while (i < j) {
			while (nums[j] >= base && i < j)
				j--;
			while (nums[i] <= base && i < j)
				i++;
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		//交换完成再进行下一组将 base 放入 i j 目前的位置
		nums[left] = nums[j];
		nums[j] = base;
		quick_sort(nums, left, j - 1);
		quick_sort(nums, j + 1, right);

	}
    public static void main(String[] args) {
		int [] nums = {-1,0,1,2,-1,-4};
		List res = new _15().threeSum(nums);
		Iterator iterator = res.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
