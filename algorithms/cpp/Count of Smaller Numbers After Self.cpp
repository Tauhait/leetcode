struct MyTreeNode {
    MyTreeNode* left;
    MyTreeNode* right;
    int value;
    int smaller;
    int equal;
    
    MyTreeNode(const int& val) {
        value = val;
        
        equal = 1;
        smaller = 0;
        left = NULL;
        right = NULL;
    }
};

class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        vector<int> ret;
        if(nums.size() == 0) {
            return ret;
        }
        
        MyTreeNode* root = new MyTreeNode(nums.back());
        ret.push_back(0);
        int n = nums.size();
        for(int i = n - 2;i >= 0;--i) {
            int smaller = 0;
            MyTreeNode* p = root;
            while(p != NULL) {
                if(nums[i] > p->value) {
                    smaller += p->smaller + p->equal;
                    if(p->right == NULL) {
                        p->right = new MyTreeNode(nums[i]);
                        p->right->smaller = 0;
                        ret.push_back(smaller);
                        break;
                    } else {
                        p = p->right;
                    }
                } else if(nums[i] < p->value) {
                    p->smaller += 1;
                    if(p->left == NULL) {
                        p->left = new MyTreeNode(nums[i]);
                        p->left->smaller = 0;
                        ret.push_back(smaller);
                        break;
                    } else {
                        p = p->left;
                    }
                } else if(nums[i] == p->value) {
                    p->equal++;
                    ret.push_back(smaller + p->smaller);
                    break;
                }
            }
        }
        
        reverse(ret.begin(), ret.end());
        return ret;
    }
};