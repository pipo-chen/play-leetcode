//
//  main.cpp
//  92
//
//  Created by zihan on 2022/1/17.
//

#include <iostream>
using namespace::std;

struct ListNode {
    int val;
    ListNode * next;
};

ListNode* Create(int data[], int n) {
    ListNode* L = (ListNode*)malloc(sizeof(struct ListNode));
    ListNode *p = L;
    for (int i = 0; i < n; i++) {
        ListNode* node = (ListNode*)malloc(sizeof(struct ListNode));
        node->val = data[i];
        node->next = NULL;
        L->next = node;
        L = L->next;
    }
    return p->next;
}

void PrintList(ListNode *L) {
    ListNode *p = L;
    if (L == NULL)
        return;
    while (p) {
        printf("%d-->",p->val);
        p = p->next;
    }
    printf("\n");
}

ListNode *reverse(ListNode *head, int left, int right) {
    ListNode *dummyHead = (ListNode *)malloc(sizeof(struct ListNode));
    dummyHead->next = head;
    ListNode *pre = dummyHead;
    
    for (int i = 1; i < left; i++) {
        pre = pre->next;
    }
    ListNode *cur = pre->next;
    for (int i = 0; i < (right - left) && cur && cur->next; i++) {
        ListNode *next = cur->next;
        cur->next = next->next;
        next->next = pre->next;
        pre->next = next;
        //cur 固定的
    }
    return dummyHead->next;
}

int main(int argc, const char * argv[]) {
    int data[] = {1,2,3,4,5};
    ListNode *head = Create(data, 5);
    PrintList(head);
    PrintList(reverse(head, 2, 4));
    return 0;
}
