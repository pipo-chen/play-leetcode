//
//  main.cpp
//  807
//
//  Created by zihan on 2022/3/18.
//

#include <iostream>
#include <vector>

using namespace::std;

int maxIncreaseKeepingSkyline(vector<vector<int>>& grid) {
    int num[grid.size()][grid.size()];
    vector<int> col_max, row_max;
    for (int i = 0; i < grid.size(); i++) {
        for (int j = 0; j < grid.size(); j++) {
            num[i][j] = 0;
        }
    }
    for(int i = 0; i < grid.size(); i++) {
        int max_col_num = -1, col_index, row_index, max_row_num = -1;
        //横向比较
        for (int j = 0; j < grid.size(); j++) {
            if (grid[i][j] > max_col_num) {
                max_col_num = grid[i][j];
                col_index = j;
            }
        }
        //竖向比较
        for (int k = 0; k < grid.size(); k++) {
            if (grid[k][i] > max_row_num) {
                max_row_num = grid[k][i];
                row_index = k;
            }
        }
        num[i][col_index] = max_col_num;
        num[row_index][i] = max_row_num;
        col_max.push_back(col_index);
        row_max.push_back(row_index);
    }
    int sum = 0;
    for (int i = 0; i < grid.size(); i++) {
        for (int j = 0; j < grid.size(); j++) {
//            cout << grid[i][col_max[i]] <<" "<< grid[row_max[j]][j] << " "<< grid[i][j]<<endl;
            if (grid[i][j] < min(grid[i][col_max[i]], grid[row_max[j]][j])) {
                sum += min(grid[i][col_max[i]], grid[row_max[j]][j]) - grid[i][j];
            }
        }
        cout << endl;
    }
    return sum;
    
}
int main(int argc, const char * argv[]) {
    vector<vector<int>> grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
    int sum = maxIncreaseKeepingSkyline(grid);
    cout << sum;
    return 0;
}
