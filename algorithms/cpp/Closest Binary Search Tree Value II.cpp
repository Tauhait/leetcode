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
    vector<int> vals;
    
    void dfs(TreeNode* root) {
        if(root->left != NULL) {
            dfs(root->left);
        }
        
        vals.push_back(root->val);
        
        if(root->right != NULL) {
            dfs(root->right);
        }
    }
    
    vector<int> closestKValues(TreeNode* root, double target, int k) {
        vector<int> ret;
        if(root == NULL || k == 0) return ret;
        
        dfs(root);
        if(vals.size() == 1) {
            ret.push_back(vals[0]);
            
            return ret;
        }
        
        int l = 0, h = vals.size() - 1, m = 0;
        double diff = 1e300;
        int id = -1;
        while(l <= h) {
            m = (l + h) / 2;
            if(vals[m] == target) {
                id = m;
                break;
            } else if(target > vals[m]) {
                if(diff > target - vals[m]) {
                    diff = target - vals[m];
                    id = m;
                }
                l = m + 1;
            } else {
                if(diff > vals[m] - target) {
                    diff = vals[m] - target;
                    id = m;
                }
                h = m - 1;
            }
        }
        
        ret.push_back(vals[id]);
        int i = id - 1, j = id + 1, p = 1;
        while(p < k && i >= 0 && j < vals.size()) {
            if(fabs(target - vals[i]) < fabs(target - vals[j])) {
                ret.push_back(vals[i]);
                i--;
            } else {
                ret.push_back(vals[j]);
                j++;
            }
            p++;
        }
        
        while(p < k && i >= 0) {
            ret.push_back(vals[i]);
            i--;   
            p++;
        }
        while(p < k && j < vals.size()) {
            ret.push_back(vals[j]);
            j++;  
            p++;
        }
        
        return ret;
    }
};