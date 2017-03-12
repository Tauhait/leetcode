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
    ListNode* deleteDuplicates(ListNode* head) {
        if(head == NULL) return head;
        
        unordered_set<int> hash_table;
        ListNode tmp = ListNode(-1);
        tmp.next = head;
        ListNode* p = &tmp;
        while(p->next != NULL) {
            if(hash_table.find(p->next->val) != hash_table.end()) {
                ListNode* f = p->next;
                p->next = p->next->next;
                free(f);
            } else {
                hash_table.insert(p->next->val);
                p = p->next;
            }
        }
        return tmp.next;
    }
};