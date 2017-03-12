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
    ListNode* swapPairs(ListNode* head) {
        if(head == NULL || head->next == NULL) return head;
        
        ListNode* first = new ListNode(-1);
        first->next = head;
        
        ListNode* p = first;
        ListNode* q = NULL;
        while(p != NULL && p->next != NULL && p->next->next != NULL) {
            q = p->next;
            ListNode* t = q->next->next;
            p->next = q->next;
            q->next->next = q;
            
            q->next = t;
            
            p = p->next->next;
        }
        
        ListNode* ret = first->next;
        delete first;
        return ret;
        
    }
};