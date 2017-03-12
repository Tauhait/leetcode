/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if(root == NULL) {
            return "()";
        }
        
        string ret;
        ret += '(';
        ret += to_string(root->val);
        ret += serialize(root->left);
        ret += serialize(root->right);
        ret += ')';
        
        return ret;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if(data.size() <= 2) {
            return NULL;
        }
        data = data.substr(1, data.size() - 2);
        
        size_t p = data.find_first_of('(');
        stack<char> s;
        s.push(data[p]);
        size_t q = p + 1;
        while(q < data.size()) {
            if(data[q] == ')') {
                if(!s.empty()) {
                    s.pop();
                }
            } else if(data[q] == '(') {
                s.push(data[q]);
            }
            q++;
            if(s.empty()) {
                break;
            }
        }
        
        TreeNode* root = new TreeNode(-1);
        string root_val = data.substr(0, p);
        root->val = atoi(root_val.c_str());
        
        root->left = deserialize(data.substr(p, q - p));
        root->right = deserialize(data.substr(q));
        
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));