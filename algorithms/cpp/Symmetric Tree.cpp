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
    bool isSymmetric(TreeNode* root) {
        if(root == NULL) {
            return true;
        }
        
        vector<TreeNode*> q;
        q.push_back(root);
        while(!q.empty()) {
            int lev_size = q.size();
            int i = 0, j = lev_size - 1;
            while(i <= j) {
                if(q[i]->val != q[j]->val) return false;
                if(q[i]->left == NULL && q[j]->right != NULL) return false;
                if(q[i]->left != NULL && q[j]->right == NULL) return false;
                if(q[i]->right == NULL && q[j]->left != NULL) return false;
                if(q[i]->right != NULL && q[j]->left == NULL) return false;
                i++;
                j--;
            }
            
            vector<TreeNode*> p;
            for(int i = 0;i < lev_size;++i) {
                if(q[i]->left != NULL) p.push_back(q[i]->left);
                if(q[i]->right != NULL) p.push_back(q[i]->right);
            }
            q.clear();
            q = p;
        }
        
        return true;
    }
};