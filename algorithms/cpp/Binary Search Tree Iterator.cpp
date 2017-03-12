/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class BSTIterator {
public:
    stack<TreeNode*> nodes;
    BSTIterator(TreeNode *root) {
        TreeNode* p = root;
        while(p!= NULL) {
            nodes.push(p);
            p = p->left;
        }
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !nodes.empty();
    }

    /** @return the next smallest number */
    int next() {
        TreeNode* top = nodes.top();
        nodes.pop();
        
        TreeNode* p = top->right;
        while(p != NULL) {
            nodes.push(p);
            p = p->left;
        }
        
        return top->val;
    }
};

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = BSTIterator(root);
 * while (i.hasNext()) cout << i.next();
 */