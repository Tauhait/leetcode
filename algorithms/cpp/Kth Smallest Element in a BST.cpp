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
    int c;
    int ret;
    void dfs(TreeNode* root, const int& k) {
        if(root == NULL) return ;
        if(c >= k) return ;
        
        if(root->left != NULL) {
            dfs(root->left, k);
        }
        c++;
        if(c == k) {
            ret = root->val;
            return ;
        }
        
        if(root->right != NULL) {
            dfs(root->right, k);
        }
        
    }
    int kthSmallest(TreeNode* root, int k) {
        c = 0;
        dfs(root, k);
        
        return ret;
    }
};