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
    ListNode* insertionSortList(ListNode* head) {
        if(head == NULL || head->next == NULL) return head;
        
        int n = 0;
        ListNode* p = head;
        while(p != NULL) {
            n++;
            p = p->next;
        }
        
        int k = 0, n2 = n / 2 - 1;
        p = head;
        while(p != NULL && k < n2) {
            k++;
            p = p->next;
        }
        ListNode* q = p->next;
        p->next = NULL;
        ListNode* p1 = insertionSortList(head);
        ListNode* p2 = insertionSortList(q);
        
        ListNode* tmp = new ListNode(-1);
        tmp->next = NULL;
        p = tmp;
        while(p1 != NULL && p2 != NULL) {
            if(p1->val < p2->val) {
                p->next = p1;
                p1 = p1->next;
            } else {
                p->next = p2;
                p2 = p2->next;
            }
            p = p->next;
        }
        
        while(p1 != NULL) {
            p->next = p1;
            p1 = p1->next;
            p = p->next;
        }
        
        while(p2 != NULL) {
            p->next = p2;
            p2 = p2->next;
            p = p->next;
        }
        
        return tmp->next;
        
    }
};