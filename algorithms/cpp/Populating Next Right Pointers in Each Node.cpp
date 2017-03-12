/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void populate(TreeLinkNode* root, TreeLinkNode* parent) {
        if(parent == NULL) {
            root->next = NULL;
        } else if(root != parent->right) {
            root->next = parent->right;
        } else if(parent->next != NULL) {
            root->next = parent->next->left;
        } else {
            root->next = NULL;
        }
        
        if(root->left != NULL) {
            populate(root->left, root);
        }
        if(root->right != NULL) {
            populate(root->right, root);
        }
    }
    
    void connect(TreeLinkNode *root) {
        if(root == NULL) {
            return;
        }
        populate(root, NULL);
    }
};