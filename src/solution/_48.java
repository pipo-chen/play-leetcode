package solution;

public class _48 {
    public void rotate(int[][] matrix) {
        //先上下对称
        int total_row = matrix.length;
        for (int row  = 0; row < total_row / 2; row ++) {
            //交换
            for (int col = 0; col < matrix[row].length; col ++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[total_row - row - 1][col];
                matrix[total_row - row - 1][col] = temp;
            }
        }

        //再对角线对称
        for (int row = 0; row < total_row; row ++) {
            for (int col = 0; col < row; col ++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

    }
    public static void main(String [] args) {
        int [][]matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        new _48().rotate(matrix);
    }
}
