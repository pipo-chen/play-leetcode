package solution;

public class _1550 {
	public boolean threeConsecutiveOdds(int[] arr) {
		int count = 0;
		for (int x: arr) {
			count = x % 2 != 0 ? count+1 : 0;
			if (count == 3)
				return true;
		}
		return false;
    }
    public static void main(String[] args) {
		int [] nums = {1,2,34,3,4,5,7,23,12};
		boolean res = new _1550().threeConsecutiveOdds(nums);
		System.out.println(res);
	}
}
