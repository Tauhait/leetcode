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
    ListNode* reverse(ListNode* head) {
        if(head == NULL || head->next == NULL) return head;
        ListNode* p = head, *q = head->next;
        while(p != NULL && q != NULL) {
            ListNode* t = q->next;
            q->next = p;
            
            p = q;
            q = t;
        }
        head->next = NULL;
        return p;
    }
    
    void reorderList(ListNode* head) {
        if(head == NULL || head->next == NULL) return;
        int n = 0;
        ListNode* p = head;
        while(p != NULL) {
            n++;
            p = p->next;
        }
        int k = n / 2;
        p = head;
        int c = 0;
        while(p != NULL && c < k) {
            p = p->next;
            c++;
        }
        ///////////////
        ListNode* q = p->next;
        p->next = NULL;
        q = reverse(q);
        p = head;
        
        while(p != NULL && q != NULL) {
            ListNode* t1 = q->next;
            ListNode* t2 = p->next;
            p->next = q;
            q->next = t2;
            
            p = t2;
            q = t1;
        }
    }
};