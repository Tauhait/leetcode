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
    int long_path;
    void dfs(TreeNode* root, const int& l) {
        long_path = max(l, long_path);
        if(root->left == NULL && root->right == NULL){
            return;
        }
        
        if(root->left != NULL) {
            if(root->left->val == root->val + 1) {
                dfs(root->left, l + 1);
            } else {
                dfs(root->left, 1);
            }
        }
        
        if(root->right != NULL) {
            if(root->right->val == root->val + 1) {
                dfs(root->right, l + 1);
            } else {
                dfs(root->right, 1);
            }
        }
    }
    
    int longestConsecutive(TreeNode* root) {
        if(root == NULL) return 0;
        long_path = 0;
        dfs(root, 1);
        
        return long_path;
    }
};