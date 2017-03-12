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
    int closestValue(TreeNode* root, double target) {
        if(root == NULL) return 0;
        
        double diff = 1e347, ret = root->val;
        while(root != NULL) {
            if(target == root->val) return target;
            else if(target > root->val) {
                if(diff > fabs(target - root->val)) {
                    diff = fabs(target - root->val);
                    ret = root->val;
                }
                root = root->right;
            } else {
                if(diff > fabs(target - root->val)) {
                    diff = fabs(target - root->val);
                    ret = root->val;
                }
                root = root->left;
            }
        }
        
        return int(ret);
    }
};