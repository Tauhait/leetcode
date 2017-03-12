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
    vector<vector<int> > ret;
    vector<int> cur;
    void dfs(TreeNode* root, const int& s, const int& sum) {
        if(root->left == NULL && root->right == NULL) {
            if(s == sum) {
                ret.push_back(cur);
            }
            
            return ;
        }
        
        if(root->left != NULL) {
            cur.push_back(root->left->val);
            dfs(root->left, s + root->left->val, sum);
            cur.pop_back();
        }
        
        if(root->right != NULL) {
            cur.push_back(root->right->val);
            dfs(root->right, s + root->right->val, sum);
            cur.pop_back();
        }
    }
    
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        ret.clear();
        if(root == NULL) {
            return ret;
        }
        cur.push_back(root->val);
        dfs(root, root->val, sum);
        cur.pop_back();
        
        return ret;
    }
};