/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 
struct StackNode {
    int l, r;
    TreeNode* parent;
    bool leftChild;
    StackNode(int _l = 1, int _r = 0, TreeNode* _parent = NULL, bool _left = false) 
    : l(_l), r(_r), parent(_parent), leftChild(_left) {}
};

class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        int n = nums.size();
        if(n == 0) return NULL;
        
        TreeNode* ret = NULL;
        stack<StackNode> st;
        st.push(StackNode(0, n - 1, NULL, false));
        while(!st.empty()) {
            StackNode top = st.top();
            st.pop();
            if(top.l == top.r) {
                TreeNode* tmp = new TreeNode(nums[top.l]);
                if(top.r - top.l + 1 == n) ret = tmp;
                if(top.parent != NULL) {
                    if(top.leftChild) top.parent->left = tmp;
                    else top.parent->right = tmp;
                }
            } else {
                int mid = top.l + (top.r - top.l) / 2;
                TreeNode* tmp = new TreeNode(nums[mid]);
                if(top.r - top.l + 1 == n) ret = tmp;
                if(top.parent != NULL) {
                    if(top.leftChild) top.parent->left = tmp;
                    else top.parent->right = tmp;
                }
                if(top.l <= mid - 1) st.push(StackNode(top.l, mid - 1, tmp, true));
                if(mid + 1 <= top.r) st.push(StackNode(mid + 1, top.r, tmp, false));
            }
        }
        
        return ret;
    }
};