//
//  main.cpp
//  507
//
//  Created by zihan on 2021/12/31.
//

#include <iostream>
#include <math.h>
using namespace::std;

bool checkPerfectNumber(int num) {
    //从当前到 某个位置
    //一定有一项 1
    if (num < 0)
        return false;
    int sum = 1;
    for (int i = 2; i <= sqrt(num); i++) {
        if (num % i == 0) {
            sum += (i + num / i);
        }
    }
    return sum == num;

}
int main(int argc, const char * argv[]) {
    cout << checkPerfectNumber(496) << endl;
    cout << checkPerfectNumber(495) << endl;
    return 0;
}
