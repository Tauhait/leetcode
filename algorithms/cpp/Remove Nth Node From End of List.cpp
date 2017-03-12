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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* p = head;
        ListNode* q = head;
        int k = 0;
        while(p != NULL && k < n) {
            k++;
            p = p->next;
        }
        if(p == NULL) {
            q = q->next;
            free(head);
            return q;
        }
        
        while(p->next != NULL) {
            p = p->next;
            q = q->next;
        }
        ListNode* t = q->next;
        q->next = q->next->next;
        free(t);
        
        
        return head;
    }
};