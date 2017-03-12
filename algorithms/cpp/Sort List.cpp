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
    ListNode* merge(ListNode* p, ListNode* q) {
        ListNode* first = new ListNode(-1);
        ListNode* r = first;
        while(p != NULL && q != NULL) {
            if(p->val < q->val) {
                r->next = p;
                r = r->next;
                p = p->next;
            } else {
                r->next = q;
                r = r->next;
                q = q->next;
            }
        }
        
        while(p != NULL) {
            r->next = p;
            r = r->next;
            p = p->next;
        }
        
        while(q != NULL) {
            r->next = q;
            r = r->next;
            q = q->next;
        }
        
        r = first->next;
        delete first;
        
        return r;
    }
    
    ListNode* sortList(ListNode* head) {
        if(head == NULL || head->next == NULL) {
            return head;
        }
        
        ListNode* fast = head;
        ListNode* slow = head;
        while(fast->next != NULL && fast->next->next != NULL) {
            fast = fast->next->next;
            slow = slow->next;
        }
        
        ListNode* p = slow->next;
        slow->next = NULL;
        
        head = sortList(head);
        p = sortList(p);
        
        ListNode* q = merge(head, p);
        
        return q;
    }
};