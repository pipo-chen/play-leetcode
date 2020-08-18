package solution;

public class _0107 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //左右对称
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
        //对角对称
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n -1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }

    }


    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        //先水平对称，再右对角线对称
        new _0107().rotate(matrix);
        System.out.println(matrix.toString());
    }
}
