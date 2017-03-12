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
    TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
        if(root == NULL) return NULL;
        
        if(p->right != NULL) {
            p = p->right;
            while(p->left != NULL) {
                p = p->left;
            }
            return p;
        }
        
        TreeNode* q = root;
        TreeNode* ret = NULL;
        while(q != NULL && q != p) {
            if(q->val > p->val) {
                ret = q;
                q = q->left;
            } else if(q->val < p->val) {
                q = q->right;
            }
        }
        
        return ret;
    }
};