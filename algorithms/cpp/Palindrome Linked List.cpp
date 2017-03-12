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
    ListNode* reverseList(ListNode* head) {
        if(head == NULL || head->next == NULL) {
            return head;
        }
        
        ListNode* p = head;
        ListNode* q = head->next;
        while(p != NULL && q != NULL) {
            ListNode* t = q->next;
            
            q->next = p;
            p = q;
            q = t;
        }
        
        head->next = NULL;
        return p;
    }
    
    bool isPalindrome(ListNode* head) {
        int N = 0;
        ListNode* p = head;
        while(p != NULL) {
            N++;
            p = p->next;
        }
        
        if(N < 2) {
            return true;
        }
        
        ListNode* par = NULL;
        p = head;
        int c = 0, n = N / 2;
        while(c < n) {
            par = p;
            p = p->next;
            c++;
        }
        
        par->next = NULL;
        ListNode* q = p;
        q = reverseList(q);
        p = head;
        
        // is palindrome
        while(p != NULL && q != NULL) {
            if(p->val != q->val) {
                return false;
            }
            p = p->next;
            q = q->next;
        }
        
        return true;
    }
};