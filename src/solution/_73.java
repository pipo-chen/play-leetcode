package solution;

import java.util.HashSet;
import java.util.Set;

public class _73 {
	public void setZeroes(int[][] matrix) {
		//通过桶进行统计
		int[] zero_i = new int[matrix.length];
		int[] zero_j = new int[matrix[0].length];

		//桶统计
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					zero_i[i] = 1;
					zero_j[j] = 1;
				}
			}
		}

		//行置零
		for (int i = 0; i < matrix.length; i++) {
			if (zero_i[i] == 1) {
				matrix[i] = new int[matrix[i].length];
			}
		}

		//列置零
		for (int j = 0; j < zero_j.length; j++) {
			if (zero_j[j] == 1) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}

    }
	public void setZeroes_set(int[][] matrix) {
		//统计 i 和 j 列为 0
		Set zero_i = new HashSet();
		Set zero_j = new HashSet();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					//记录 i 列 j 列
					zero_i.add(i);
					zero_j.add(j);
				}
			}
		}


		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (zero_i.contains(i) || zero_j.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
    }
    public static void main(String[] args) {
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		new _73().setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}
}
