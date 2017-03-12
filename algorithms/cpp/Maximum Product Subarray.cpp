class Solution {
public:
    int maxProduct(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        int large = nums[0];
        int small = nums[0];
        int ret = large;
        for(int i = 1;i < nums.size();++i) {
            int l = nums[i] * large;
            int r = nums[i] * small;
            large = max(max(nums[i], l), r); 
            small = min(min(nums[i], l), r);
            if(large > ret) ret = large;
        }
        
        return ret;
    }
};