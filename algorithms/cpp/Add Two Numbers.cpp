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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int c = 0;
        ListNode* pre_head = new ListNode(-1);
        ListNode* p = pre_head;
        
        ListNode* p1 = l1, *p2 = l2;
        while(p1 != NULL && p2 != NULL) {
            int s = c + p1->val + p2->val;
            p1->val = s % 10;
            ListNode* node = new ListNode(s % 10);
            p->next = node;
            p = p->next;
            c = s / 10;
            p1 = p1->next;
            p2 = p2->next;
            
        }
        while(p1 != NULL) {
            int s = c + p1->val;
            ListNode* node = new ListNode(s % 10);
            p->next = node;
            p = p->next;
            c = s / 10;
            p1 = p1->next;
        }
        while(p2 != NULL) {
            int s = c + p2->val;
            ListNode* node = new ListNode(s % 10);
            p->next = node;
            p = p->next;
            c = s / 10;
            p2 = p2->next;
        }
        if(c != 0) {
            ListNode* node = new ListNode(c);
            p->next = node;
            p= p->next;
        }
        
        //return pre_head->next;
        ListNode* ret = pre_head->next;
        delete pre_head;
        return ret;
        
    }
};