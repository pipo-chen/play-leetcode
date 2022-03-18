//
//  main.cpp
//  169
//
//  Created by zihan on 2022/3/18.
//

#include <iostream>
#include <vector>
#include <map>

using namespace::std;

int m(vector<int>& nums) {
    map<int, int>cmap;
    for (int i = 0; i < nums.size(); i++) {
        //判断是否有key
        if(cmap.count(nums[i]) == 0) {
            cmap[nums[i]] = 1;
        } else {
            cmap[nums[i]] = cmap[nums[i]] + 1;
        }
    }
    int max_num = -1, max_index = -1;
    
    for(map<int, int>:: iterator iter = cmap.begin(); iter != cmap.end(); iter++) {
        if (iter->second > max_num) {
            max_num = iter->second;
            max_index = iter->first;
        }
    }

    return max_index;
}

int main(int argc, const char * argv[]) {
    vector<int>nums = {2,2,1,1,1,2,2};
    int res = m(nums);
    cout << res << endl;
    return 0;
}
