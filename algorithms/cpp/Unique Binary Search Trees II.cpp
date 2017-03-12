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
    void generateSubtree(const int& s, const int& e, vector<TreeNode*>& possibleTree) {
        if(s > e) {
            possibleTree.push_back(NULL);
            return ;
        } else if(s == e) {
            TreeNode* node = new TreeNode(s);
            possibleTree.push_back(node);
            return;
        } else if(e - s == 1) {
            TreeNode* node1 = new TreeNode(s);
            TreeNode* node2 = new TreeNode(e);
            
            node1->right = node2;
            possibleTree.push_back(node1);
            
            TreeNode* nodea = new TreeNode(s);
            TreeNode* nodeb = new TreeNode(e);
            
            nodeb->left = nodea;
            possibleTree.push_back(nodeb);
            
            return ;
        } else {
            for(int i = s;i <= e;++i) {
                vector<TreeNode*> possibleLeft;
                vector<TreeNode*> possibleRight;

                generateSubtree(s, i - 1, possibleLeft);
                generateSubtree(i + 1, e, possibleRight);
                
                for(int j = 0;j < possibleLeft.size();++j) {
                    for(int k = 0;k < possibleRight.size();++k) {
                        TreeNode* root = new TreeNode(i);
                        root->left = possibleLeft[j];
                        root->right = possibleRight[k];
                        possibleTree.push_back(root);
                    }
                }
            }
            
            return;
        }
    }
    
    vector<TreeNode*> generateTrees(int n) {
        vector<TreeNode*> ret;
        generateSubtree(1, n, ret);
        
        return ret;
    }
};
