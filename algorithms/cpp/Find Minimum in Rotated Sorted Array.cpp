class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        
        int ret = nums[0];
        int l = 0, h = nums.size() - 1;
        while(l <= h) {
            int m = (l + h) / 2;
            if(nums[m] >= nums[l]) {
                ret = min(ret, nums[l]);
                l = m + 1;
            } else {
                ret = min(ret, nums[m]);
                h = m - 1;
            }
        }
        
        return ret;
    }
};