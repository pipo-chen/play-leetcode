package solution;

public class _202 {
    public boolean isHappy(int n) {
        int count = 0;
        while (n != 1) {
            n = sumOfN(n);
            count++;
            if (count > 30) {
                return false;
            }
        }
        return true;
    }

    public int sumOfN(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 2;
        boolean res = new _202().isHappy(n);
        System.out.println(res);
    }
}
