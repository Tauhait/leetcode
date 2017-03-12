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
    bool ret;
    void dfs(TreeNode* root, const int& sum, int cur) {
        if(root->left == NULL && root->right == NULL) {
            if(sum == cur) ret = true;
            
            return;
        }
        if(root->left) {
            dfs(root->left, sum, cur + root->left->val);
        }
        if(root->right) {
            dfs(root->right, sum, cur + root->right->val);
        }
    }
    bool hasPathSum(TreeNode* root, int sum) {
        if(root == NULL) {
            return false;
        }
        ret = false;
        dfs(root, sum, root->val);
        
        return ret;
    }
};