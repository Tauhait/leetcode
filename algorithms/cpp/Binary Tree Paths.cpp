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
    vector<string> paths;
    void dfs(TreeNode* root, vector<int>& cur_path) {
        if(root->left == NULL && root->right == NULL) {
            string path;
            char chr[100];
            sprintf(chr, "%d", cur_path[0]);
            path += chr;
            for(size_t i = 1;i < cur_path.size();++i) {
                sprintf(chr, "->%d", cur_path[i]);
                path += chr;
            }
            paths.push_back(path);
            return;
        }
        
        // left child
        if(root->left != NULL) {
            cur_path.push_back(root->left->val);
            dfs(root->left, cur_path);
            cur_path.pop_back();
        }
        
        // right chlid
        if(root->right != NULL) {
            cur_path.push_back(root->right->val);
            dfs(root->right, cur_path);
            cur_path.pop_back();
        }
    }
    
    vector<string> binaryTreePaths(TreeNode* root) {
        if(root == NULL) return paths;
        
        vector<int> cur_path;
        cur_path.push_back(root->val);
        dfs(root, cur_path);
        cur_path.pop_back();
        
        return paths;
    }
};