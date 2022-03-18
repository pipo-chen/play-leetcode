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
    vector<int> maxRow(grid.size());
    vector<int> maxCol(grid[0].size());
    for (int i = 0 ; i < grid.size(); i++) {
        for (int j = 0; j < grid.size(); j++) {
            maxRow[i] = max(maxRow[i], grid[i][j]);
            maxCol[j] = max(maxCol[j], grid[i][j]);
        }
    }
    int res = 0;
    for (int i = 0; i < grid.size(); i++) {
        for (int j = 0; j < grid.size(); j++) {
            res += min(maxRow[i], maxCol[j]) - grid[i][j];
        }
    }
    return res;
    
}
int main(int argc, const char * argv[]) {
    vector<vector<int>> grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
    int sum = maxIncreaseKeepingSkyline(grid);
    cout << sum;
    return 0;
}
