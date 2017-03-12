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
    ListNode* rotateRight(ListNode* head, int k) {
        if(head == NULL) return NULL;
        int l = 0;
        ListNode* node = head;
        while(node != NULL) {
            l++;
            node = node->next;
        }
        k = k % l;
        
        ListNode* p = head;
        ListNode* q = head;
        
        int n = 0;
        while(p != NULL && n < k) {
            p = p->next;
            n++;
        }
        
        while(p->next != NULL) {
            p = p->next;
            q = q->next;
        }
        
        p->next = head;
        ListNode* ret = q->next;
        q->next = NULL;
        
        return ret;
    }
};