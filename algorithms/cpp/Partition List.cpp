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
    ListNode* partition(ListNode* head, int x) {
        if(head == NULL) return head;
        
        ListNode* small = new ListNode(0);
        ListNode* large = new ListNode(0);
        
        ListNode* p = head;
        ListNode* ps = small;
        ListNode* pl = large;
        int prelarge = 0;
        while(p != NULL) {
            if(p->val == x) {
                pl->next = p;
                pl = pl->next;
            } else if(p->val > x) {
                pl->next = p;
                pl = pl->next;
                prelarge = 1;
            } else {
                ps->next = p;
                ps = ps->next;
                prelarge = 0;
            }
            p = p->next;
        }
        
        ps->next = large->next;
        pl->next = NULL;
        
        return small->next;
    }
};