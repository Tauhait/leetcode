/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 
struct ReturnType {
    ReturnType(const bool& _isBST, const int& _num_of_nodes, const long long& _max_val, const long long& _min_val) {
        isBST = _isBST;
        num_of_nodes = _num_of_nodes;
        max_val = _max_val;
        min_val = _min_val;
    }
    
    bool isBST;
    int num_of_nodes;
    long long max_val;
    long long min_val;
};

class Solution {
public:
    int largestBST;
    ReturnType largestBSTSubtree2(TreeNode* root) {
        if(root == NULL) {
            return ReturnType(true, 0, LLONG_MIN, LLONG_MAX);
        }
        
        ReturnType left = largestBSTSubtree2(root->left);
        ReturnType right = largestBSTSubtree2(root->right);
        
        if(left.isBST == true && right.isBST == true && 
           root->val < right.min_val && root->val > left.max_val) {
            largestBST = max(largestBST, left.num_of_nodes + right.num_of_nodes + 1);
            long long max_val = root->right == NULL ? root->val : right.max_val;
            long long min_val = root->left == NULL ? root->val : left.min_val;
            return ReturnType(true, left.num_of_nodes + right.num_of_nodes + 1, max_val, min_val);
        } else {
            return ReturnType(false, 0, LLONG_MAX, LLONG_MIN); 
        }
    }
    
    int largestBSTSubtree(TreeNode* root) {
        if(root == NULL) return 0;
        if(root->left == NULL && root->right == NULL) {
            return 1;
        }
        
        largestBST = 0;
        largestBSTSubtree2(root);
        
        return largestBST;
    }
};