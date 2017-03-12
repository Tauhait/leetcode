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
    ListNode* reverseLinkList(ListNode* head) {
        if(head == NULL || head->next == NULL) return head;
        ListNode* p = head, *q = head->next;
        while(q != NULL) {
            ListNode* t = q->next;
            q->next = p;
            p = q;
            q = t;
        }
        head->next = NULL;
        
        return p;
    }
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(k == 1) return head;
        
        ListNode* first = new ListNode(-1);
        first->next = head;
        
        ListNode* p = first;
        while(p->next != NULL) {
            int i = 0;
            ListNode* q = p;
            while(q->next != NULL && i < k) {
                q = q->next;
                i++;
            }
            if(i == k) {
                ListNode* t = q->next;
                q->next = NULL;
                q = reverseLinkList(p->next);
                p->next = q;
                while(p->next != NULL) {
                    p = p->next;
                }
                p->next = t;
                
            } else {
                break;
            }
        }

        return first->next;
    }
};