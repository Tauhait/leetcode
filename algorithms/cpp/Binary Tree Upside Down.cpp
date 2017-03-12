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
    TreeNode* upsideDownBinaryTree(TreeNode* root) {
        if(root == NULL || root->left == NULL) return root;
        
        TreeNode* left = root->left;
        TreeNode* right = root->right;
        TreeNode* pre = root;
        root->left = NULL;
        root->right = NULL;
        while(left != NULL) {
            TreeNode* l = left->left;
            TreeNode* r = left->right;
            
            left->left = right;
            left->right = pre;
            
            pre = left;
            left = l;
            right = r;
        }
        
        return pre;
    }
};