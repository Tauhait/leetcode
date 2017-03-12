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
    TreeNode* buildTree(const vector<int>& preorder, const int& pre_s, const int& pre_e,
                        const vector<int>& inorder, const int& in_s, const int& in_e) {
        if(pre_s > pre_e || in_s > in_e || pre_e - pre_s != in_e - in_s) {
            return NULL; // invalid or empty node
        }
        
        int root_index_inorder = -1;
        for(int i = in_s;i <= in_e;++i) {
            if(inorder[i] == preorder[pre_s]) {
                root_index_inorder = i;
                break;
            }
        }
        
        if(root_index_inorder == -1) {
            return NULL; // invalid
        }
        
        TreeNode* root = new TreeNode(preorder[pre_s]);
        root->left = buildTree(preorder, pre_s + 1, pre_s + 1 + root_index_inorder - 1 - in_s, inorder, in_s, root_index_inorder - 1);
        root->right = buildTree(preorder, pre_e - in_e + (root_index_inorder + 1), pre_e, inorder, root_index_inorder + 1, in_e);
        
        return root;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.size() != inorder.size() || preorder.size() == 0) {
            return NULL; // invalid or empty tree
        }
        
        return buildTree(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1);
    }
};