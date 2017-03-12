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
    
    TreeNode* buildTree(const vector<int>& inorder, const int& in_s, const int& in_e,
        const vector<int>& postorder, const int& post_s, const int& post_e) {
        if(in_s > in_e || post_s > post_e || in_e - in_s != post_e - post_s) {
            return NULL; // invalid
        }
        
        int root_index_inorder = -1;
        for(int i = in_s;i <= in_e;++i) {
            if(inorder[i] == postorder[post_e]) {
                root_index_inorder = i;
                break;
            }
        }
        
        if(root_index_inorder == -1) {
            return NULL; // invalid
        }
        
        TreeNode* root = new TreeNode(postorder[post_e]);
        root->left = buildTree(inorder, in_s, root_index_inorder - 1, postorder, post_s, post_s + root_index_inorder - 1 - in_s);
        root->right = buildTree(inorder, root_index_inorder + 1, in_e, postorder, post_s + root_index_inorder - 1 - in_s + 1, post_e - 1);
        
        return root;
    }

    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(inorder.size() != postorder.size() || inorder.size() == 0) {
            return NULL; // invalid;
        }
        
        return buildTree(inorder, 0, inorder.size() - 1, postorder, 0, postorder.size() - 1);
    }
};