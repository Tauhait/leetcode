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
    void Output(ListNode* head) {
        ListNode* p = head;
        cout << "val: ";
        while(p != NULL) {
            cout << " " << p->val;
            p = p->next;
        }
        cout << endl;
    }
    ListNode* reverseList(ListNode* head) {
        Output(head);
        cout << "hao" << endl;
        if(head == NULL || head->next == NULL) return head;
        
        ListNode* p = head;
        ListNode* q = head->next;
        while(q != NULL) {
            ListNode* t = q->next;
            q->next = p;
            p = q;
            q = t;
        }
        head->next = NULL;
        
        Output(p);
        
        return p;
    }
    
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        if(head == NULL) return NULL;
        
        ListNode* first = new ListNode(-1);
        first->next = head;
        
        int l = 1;
        ListNode* p = first;
        while(l < m) {
            p = p->next;
            l++;
        }
        ListNode* pn = p->next;
        
        l = 1;
        ListNode* q = head;
        while(l < n) {
            q = q->next;
            l++;
        }
        
        ListNode* qn = q->next;
        q->next = NULL;
        
        ListNode* r = reverseList(p->next);
        Output(r);
        p->next = r;
        pn->next = qn;
        
        
        ListNode* ret = first->next;
        delete first;
        return ret;
    }
};