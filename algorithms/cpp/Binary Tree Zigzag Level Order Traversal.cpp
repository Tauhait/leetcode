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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int > > ret;
        if(root == NULL) return ret;
        queue<TreeNode*> q;
        q.push(root);
        int lev = 0;
        while(!q.empty()) {
            lev++;
            int s = q.size();
            vector<int> res(s, 0);
            for(int i = 0;i < s;++i) {
                TreeNode* t = q.front();
                q.pop();
                res[i] = t->val;
                if(t->left != NULL) {
                    q.push(t->left);
                }
                if(t->right != NULL) {
                    q.push(t->right);
                }
            }
            if(lev % 2 == 0) {
                reverse(res.begin(), res.end());
            }
            ret.push_back(res);
        }
        
        return ret;
    }
};