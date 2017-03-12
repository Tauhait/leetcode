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
    int rob(TreeNode* root) {
        if(root == NULL) return 0;
        if(root->left == NULL && root->right == NULL) return root->val;
        
        int root_include = root->val;
        if(root->left != NULL) {
            root_include += rob(root->left->left) + rob(root->left->right);
        }
        
        if(root->right != NULL) {
            root_include += rob(root->right->left) + rob(root->right->right);
        }
        
        //////
        int root_exclude = rob(root->left) + rob(root->right);
        
        return max(root_include, root_exclude);
    }
};