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

    int isB(TreeNode* root) {
        if(root == NULL) return 0;
        if(root->left == NULL && root->right == NULL) return 1;
        
        int l = isB(root->left);
        int r = isB(root->right);
        if(l == -1 || r == -1) return -1;
        
        if(l == r) return l + 1;
        if(l == r + 1) return r + 2;
        if(l + 1 == r) return l + 2;
        
        return -1;
    }
    


    bool isBalanced(TreeNode* root) {
        if(root == NULL) return true;
        
        int is = isB(root);
        
        if(is == -1) return false;
        
        return true;
    }
};