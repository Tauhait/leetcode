class Solution {
public:
    int rob_I(vector<int>& nums) {
        size_t n = nums.size();
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        int norob_pr = 0;
        int rob_pr = nums[0];
        for(size_t i = 1;i < n;++i) {
            int norob = max(norob_pr, rob_pr);
            int rob = norob_pr + nums[i];
            norob_pr = norob;
            rob_pr = rob;
        }
        
        return max(norob_pr, rob_pr);
    }
    
    int rob(vector<int>& nums) {
        size_t n = nums.size();
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return max(nums[0], nums[1]);
        if(n == 3) return max(nums[0], max(nums[1], nums[2]));
        
        vector<int> nums_1(nums.size() - 1);
        for(int i = 1;i < nums.size();++i) {
            nums_1[i - 1] = nums[i];
        }
        
        vector<int> nums_2(nums.size() - 3);
        for(int i = 2; i < n - 1;++i) {
            nums_2[i - 2] = nums[i];
        }
        
        return max(rob_I(nums_1), rob_I(nums_2) + nums[0]);
        
    }
};