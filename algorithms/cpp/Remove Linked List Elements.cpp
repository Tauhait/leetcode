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
    ListNode* removeElements(ListNode* head, int val) {
        ListNode tmp(0);
        tmp.next = head;
        ListNode* p = &tmp;
        while(p->next != NULL) {
            if(p->next->val == val) {
                ListNode * tmp = p->next;
                p->next = p->next->next;
                free(tmp);
            } else {
                p = p->next;
            }
        }
        
        return tmp.next;
    }
};