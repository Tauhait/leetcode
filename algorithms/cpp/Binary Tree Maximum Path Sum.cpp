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
    int ret;
    int maxPath(TreeNode* root) {
        if(root == NULL) return 0;
        if(root->left == NULL && root->right == NULL) {
            ret = max(ret, root->val);
            return root->val;
        }
        
        int l = 0, r = 0;
        if(root->left != NULL) {
            l = maxPath(root->left);
        }
        if(root->right != NULL) {
            r = maxPath(root->right);
        }
        
        ret = max(ret, max(root->val, max(root->val + l + r, max(root->val + l, root->val + r))));
        
        return max(root->val, max(root->val + l, root->val + r));
    }
    
    int maxPathSum(TreeNode* root) {
        ret = INT_MIN;   
        maxPath(root);
        
        return ret;
    }
};