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
    TreeNode* flat(TreeNode* root) {
        if(root == NULL) return root;
        if(root ->left == NULL && root->right == NULL) return root;
        
        if(root->left != NULL && root->right == NULL) {
            TreeNode* p = flat(root->left);
            root->right = p;
            root->left = NULL;
        } else if(root->left == NULL && root->right != NULL) {
            TreeNode* p = flat(root->right);
            root->right = p;
            root->left = NULL;
        } else if(root->left != NULL && root->right != NULL) {
            TreeNode* p1 = flat(root->left);
            TreeNode* p2 = flat(root->right);
            root->right = p1;
            root->left = NULL;
            TreeNode* p = root;
            while(p->right != NULL) {
                p = p->right;
            }
            p->right= p2;
        }
        return root;
    }
    void flatten(TreeNode* root) {
        flat(root);
    }
};