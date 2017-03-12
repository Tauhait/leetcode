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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int> > lev_node_val;
        if(root == NULL) {
            return lev_node_val;
        }
        
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()) {
            int n = q.size();
            vector<int> lev_vals;
            for(int i = 0;i < n;++i) {
                TreeNode* front = q.front();
                q.pop();
                lev_vals.push_back(front->val);
                if(front->left != NULL) {
                    q.push(front->left);
                }
                if(front->right != NULL) {
                    q.push(front->right);
                }
            }
            lev_node_val.push_back(lev_vals);
        }
        
        return lev_node_val;
    }
};