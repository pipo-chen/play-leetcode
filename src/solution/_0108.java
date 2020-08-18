package solution;

import java.util.ArrayList;
import java.util.List;

public class _0108 {
    public void setZeroes(int[][] matrix) {
        List zero_i = new ArrayList();
        List zero_j = new ArrayList();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zero_j.add(j);
                    zero_i.add(i);
                }
            }
        }
        //再进行全数组变更
        for (int i = 0;i<matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
               //判断行是否在 zero_col 里面
                if (zero_i.contains(i) || zero_j.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int [][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new _0108().setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }

    }
}
