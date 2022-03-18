//
//  main.cpp
//  169
//
//  Created by zihan on 2022/3/18.
//

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace::std;

int m(vector<int>& nums) {
    unordered_map<int, int> counts;
    int majority = 0, cnt = 0;
    for (int num : nums) {
        ++counts[num];
        if (counts[num] > cnt) {
            majority = num;
            cnt = counts[num];
        }
    }
    return majority;
}

int main(int argc, const char * argv[]) {
    vector<int>nums = {2,2,1,1,1,2,2};
    int res = m(nums);
    cout << res << endl;
    return 0;
}
