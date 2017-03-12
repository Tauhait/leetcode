class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        
        vector<int> opt(nums.size(), 0);
        opt[0] = nums[0];
        for(size_t i = 1;i < nums.size();++i) {
            opt[i] = max(nums[i], opt[i - 1] + nums[i]);
        }
        int ret = opt[0];
        for(size_t i = 1;i < nums.size();++i) {
            ret = max(ret, opt[i]);
        }
        return ret;
    }
};