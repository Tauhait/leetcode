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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ret;
        if(root == NULL) return ret;
        stack<TreeNode*> s;
        TreeNode* p = root;
        while(p->left != NULL) {
            s.push(p);
            p = p->left;
        }
        s.push(p);
        
        while(!s.empty()) {
            TreeNode* top = s.top();
            s.pop();
            
            ret.push_back(top->val);
            if(top->right != NULL) {
                p = top->right;
                while(p->left != NULL) {
                    s.push(p);
                    p = p->left;
                }
                s.push(p);
            }
        }
        
        return ret;
    }
};