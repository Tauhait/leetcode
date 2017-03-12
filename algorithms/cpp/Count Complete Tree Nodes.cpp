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

    int countNodes(TreeNode* root) {
        if(root == NULL) return 0;
        if(root->right == NULL && root->left == NULL) return 1;
        if(root->right == NULL && root->left != NULL) return 2;
        
        int r = 1;
        TreeNode* p = root;
        while(p->right != NULL) {
            r++;
            p = p->right;
        }
        
        int l = 1;
        p = root;
        while(p->left != NULL) {
            l++;
            p = p->left;
        }
        
        if(l == r) {
            int b = 1;
            int ret = 0;
            for(int i = 0;i < l;++i) {
                ret += b;
                b *= 2;
            }
            
            return ret; 
        }
        
        p = root->right;
        int lev = 1;
        while(p->left != NULL) {
            lev++;
            p = p->left;
        }
        if(lev == r) {
            int b = 1;
            int ret = 1;
            for(int i = 1;i < l;++i) {
                ret += b;
                b *= 2;
            }
            return ret + countNodes(root->right);             
        } else {
            int b = 1;
            int ret = 1;
            for(int i = 1;i < r;++i) {
                ret += b;
                b *= 2;
            }
            return ret + countNodes(root->left);
        }
    }
};
