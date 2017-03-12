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
    
    bool IsUnivalSubtree(TreeNode* root) {
        if(root->left == NULL && root->right == NULL) {
            return true;
        }
        else if(root->left == NULL && root->right != NULL) {
            bool r = IsUnivalSubtree(root->right);
            if(r) ret++;
            
            if(r && root->right->val == root->val) {
                return true;
            } else {
                return false;
            }
        } else if(root->left != NULL && root->right == NULL) {
            bool l = IsUnivalSubtree(root->left);
            if(l) ret++;
            if(l && root->left->val == root->val) {
                return true;
            } else {
                return false;
            }
        } else {
            bool l = IsUnivalSubtree(root->left);
            bool r = IsUnivalSubtree(root->right);
            if(l) ret++;
            if(r) ret++;
            if(l && r &&
               root->left->val == root->val && root->right->val == root->val) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    int countUnivalSubtrees(TreeNode* root) {
        if(root == NULL) return 0;
        ret = 0;
        if(IsUnivalSubtree(root)) {
            ret++;
        }
        
        return ret;
    }
};