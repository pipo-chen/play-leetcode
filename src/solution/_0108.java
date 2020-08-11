package solution;

public class _0108 {
    public void setZeroes(int[][] matrix) {
        int [] zero_row = new int[matrix.length];
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            int [] arr = matrix[i];
            for (int j =0; j < arr.length; j++) {
                if (arr[j] == 0) {
                    //整行置换为 0
                    int m = 0;
                    while (m < arr.length) {
                        arr[m++] = 0;
                        //整个for循环停止
                    }
                    //记录需要置换的列
                    zero_row[count++] = j;
                }
                //循环 列
                for (int k = 0; k <count; k++) {
                    if (j == zero_row[k]) {
                        arr[j] = 0;
                    }
                }

            }
        }

        for (int [] data : matrix) {
            for (int n : data)
            {
                System.out.print(n+" ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        int [][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        new _0108().setZeroes(matrix);

    }
}
