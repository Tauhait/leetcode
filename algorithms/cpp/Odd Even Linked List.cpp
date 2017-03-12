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
    ListNode* oddEvenList(ListNode* head) {
        if(head == NULL || head->next == NULL || head->next->next == NULL) return head;
        
        ListNode* even = new ListNode(-1);
        ListNode* p = head;
        ListNode* q = head->next;
        ListNode* ep = even;
        while(p != NULL && q != NULL) {
            ListNode* t = q->next;
            ep->next = q;
            p->next = t;
            ep = ep->next;
            ep->next = NULL;
            
            if(t != NULL) {
                p = t;
                q = p->next;
            } else break;
        }
        p->next = even->next;
        
        delete even;
        
        return head;
    }
};