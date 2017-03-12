/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* upsideDownBinaryTree(struct TreeNode* root) {
    if (root == NULL || root->left == NULL)
      return root;

    struct TreeNode* left = root->left;
    struct TreeNode* right = root->right;
    struct TreeNode* pre = root;
    root->left = NULL;
    root->right = NULL;
    struct TreeNode* l;
    struct TreeNode* r;
    while (left != NULL) {
      l = left->left;
      r = left->right;

      left->left = right;
      left->right = pre;

      pre = left;
      left = l;
      right = r;
    }

    return pre;
}