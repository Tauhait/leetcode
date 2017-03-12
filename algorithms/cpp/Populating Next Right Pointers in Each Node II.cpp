/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        if(root == NULL) return ;
        
        stack<TreeLinkNode*> s;
        s.push(root);
        while(!s.empty()) {
            TreeLinkNode* p = s.top();
            s.pop();
            
            if(p->left == NULL && p->right == NULL) continue;
       
            TreeLinkNode* q = p->next;
            TreeLinkNode* c = NULL;
            while(q != NULL) {
                if(q->left != NULL) {
                    c = q->left;
                    break;
                } else if(q->right != NULL) {
                    c = q->right;
                    break;
                } else {
                    q = q->next;
                }
            }
            if(p->left != NULL && p->right != NULL) {
                p->left->next = p->right;
                p->right->next = c;
            } else {
                if(p->left != NULL) {
                    p->left->next = c;
                } else if(p->right != NULL) {
                    p->right->next = c;
                }
            }
            
            if(p->left != NULL) { // left push first, then first travse right node ****
                s.push(p->left);
            } 
            if(p->right != NULL) {
                s.push(p->right);
            }
        }
    }
};