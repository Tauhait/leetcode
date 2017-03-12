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
    int sumNumbers(TreeNode* root) {
        if(root == NULL) return 0;
        int ret = 0;
        queue<pair<TreeNode*, int> > q;
        q.push(make_pair(root, root->val));
        while(!q.empty()) {
            pair<TreeNode*, int> f = q.front();
            q.pop();
            
            if(f.first->left == NULL && f.first->right == NULL) {
                ret += f.second;
            } else {
                if(f.first->left != NULL) {
                    q.push(make_pair(f.first->left, f.second * 10 + f.first->left->val));
                }
                if(f.first->right != NULL) {
                    q.push(make_pair(f.first->right, f.second * 10 + f.first->right->val));
                }
            }
        }
        
        return ret;    
    }
};