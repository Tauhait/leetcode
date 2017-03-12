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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ret;
        if(root == NULL) return ret;
        if(root->left == NULL && root->right == NULL) {
            ret.push_back(root->val);
            return ret;
        }
        
        queue<pair<TreeNode*, int> > q;
        q.push(make_pair(root, 0));
        int l = -1, p_val = 0;
        while(!q.empty()) {
            pair<TreeNode*, int> f = q.front();
            q.pop();
            if(f.second != l && l != -1) {
                ret.push_back(p_val);
            }
            l = f.second;
            p_val = f.first->val;
            
            if(f.first->left != NULL) {
                q.push(make_pair(f.first->left, l + 1));
            }
            if(f.first->right != NULL) {
                q.push(make_pair(f.first->right, l + 1));
            }
        }
        ret.push_back(p_val);
        
        return ret;
    }
};