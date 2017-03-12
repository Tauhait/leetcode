/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    int LinkListLength(ListNode* head) {
        ListNode* p = head;
        int ret = 0;
        while(p != NULL) {
            ret++;
            p = p->next;
        }
        
        return ret;
    }

    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int m = LinkListLength(headA);
        int n = LinkListLength(headB);
        if(m < n) {
            swap(headA, headB);
            swap(m, n);
        }
        
        int d = m - n;
        ListNode* p = headA;
        for(int i = 1;i <= d;++i) {
            p = p->next;
        }
        
        ListNode* q = headB;
        while(p != NULL && q != NULL) {
            if(p == q) return p;
            p = p->next;
            q = q->next;
        }
        
        return NULL;
    }
};