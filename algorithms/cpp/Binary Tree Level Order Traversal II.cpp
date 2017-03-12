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
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int> > ret;
        if(root == NULL) return ret;
        
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()) {
            int n = q.size();
            vector<int> lev;
            for(int i = 0;i < n;++i) {
                TreeNode* front = q.front();
                q.pop();
                lev.push_back(front->val);
                if(front->left != NULL) {
                    q.push(front->left);
                }
                if(front->right != NULL) {
                    q.push(front->right);
                }
            }
            ret.push_back(lev);
        }
        reverse(ret.begin(), ret.end());
        
        return ret;        
    }
};