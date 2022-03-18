//
//  main.cpp
//  102
//
//  Created by zihan on 2022/1/17.
//

#include <iostream>
#include <queue>

using namespace::std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
};
vector<vector<int>> levelOrder(TreeNode* root) {
    vector<vector<int>> res;
    queue<TreeNode *> q;
    if (!root)
        return res;
    q.push(root);
    while (!q.empty()) {
        //输出头节点 把当前队列中的元素个数记录一下
        int size = q.size();
        vector<int> group;
        for (int i = 0; i < size; i++) {
            TreeNode *cur = q.back();
            group.push_back(cur->val);
            q.pop();
            if (root->left) {
                q.push(cur->left);
            }
            if (root->right) {
                q.push(cur->right);
            }
        }
        res.push_back(group);
    }
    return res;
}
int main(int argc, const char * argv[]) {
    
    
    return 0;
}

vector<vector<int>> ret;
   if (!root) {
       return ret;
   }
   queue<TreeNode *>q;
   q.push(root);
   while (!q.empty()) {
       //当前队列中的节点为一组，后面增的不算
       int currentLevelSize = q.size();
       vector<int> group;
       for (int i = 1; i <= currentLevelSize; i++) {
           auto node = q.front();
           q.pop();
           if (node->left)
               q.push(node->left);
           if (node->right)
               q.push(node->right);
       }
       ret.push_back(group);
   }
   return  ret;
