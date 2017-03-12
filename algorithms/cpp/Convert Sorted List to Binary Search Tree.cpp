/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* sortedListToBST(ListNode* head) {
        if(head == NULL) return NULL;
        
        int height = 0;
        ListNode* p = head;
        while(p != NULL) {
            height++;
            p = p->next;
        }
        
        if(height == 1) {
            TreeNode* treeRoot = new TreeNode(head->val);
            
            return treeRoot;
        } else if(height == 2) {
            TreeNode* treeRoot = new TreeNode(head->next->val);
            TreeNode* left = new TreeNode(head->val);
            treeRoot->left = left;
            
            return treeRoot;
        }
        
        p = head;
        int i = 1;
        height /= 2;
        while(p != NULL && i < height) {
            i++;
            p = p->next;
        }
        
        TreeNode* treeRoot = new TreeNode(p->next->val);
        ListNode* q =  p->next->next;
        p->next = NULL;
        
        treeRoot->left = sortedListToBST(head);
        treeRoot->right = sortedListToBST(q);
        
        return treeRoot;
    }
};