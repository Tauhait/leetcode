/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 
struct CMP {
    bool operator()(ListNode* a, ListNode* b) const {
        return a->val > b->val;
    }
};
 
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>, CMP> pq;
        for(int i = 0;i < lists.size();++i) {
            if(lists[i] != NULL) {
                pq.push(lists[i]);
            }
        }
        
        ListNode* head = new ListNode(-1), *p = head;
        while(!pq.empty()) {
            ListNode* t = pq.top();
            pq.pop();
            p->next = t;
            p = p->next;
            t = t->next;
            if(t != NULL) pq.push(t);
        }
        
        p = head->next;
        delete head;
        
        return p;
    }
};