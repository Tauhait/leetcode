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
    bool isValidBST(TreeNode* root, const long long& max_val, const long long& min_val) {
        if(root == NULL) return true;
        if(root->val >= max_val || root->val <= min_val) return false;
        
        return isValidBST(root->left, root->val, min_val) && 
               isValidBST(root->right, max_val, root->val);
    }
    
    bool isValidBST(TreeNode* root) {
        if(root == NULL) return true;
        if(root->left == NULL && root->right == NULL) return true;
        
        return isValidBST(root, LLONG_MAX, LLONG_MIN);
    }
};