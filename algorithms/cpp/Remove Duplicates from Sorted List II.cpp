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
    ListNode* deleteDuplicates(ListNode* head) {
        if(head == NULL) return head;
        ListNode* ret = new ListNode(INT_MAX);
        ret->next = head;
        ListNode* p = ret;
        ListNode* q = ret->next;
        while(p!= NULL && q != NULL) {
            
                int c = 0;
                while(q->next != NULL && q->next->val == q->val) {
                    c = 1;
                    ListNode* t = q;
                    q = q->next;
                    free(t);
                }
                if(c == 0) {
                    p->next = q;
                    p = q;
                    q = q->next;
                } else {
                    q = q->next;
                }
                if(q == NULL) {
                    p->next = NULL;
                }
            
        }
        
        return ret->next;
    }
};