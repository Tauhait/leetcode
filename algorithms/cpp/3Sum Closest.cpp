class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int n = nums.size();
        if(n < 3) return 0;
        sort(nums.begin(), nums.end());
        
        int diff = INT_MAX, ret = 0;
        for(size_t i = 0;i < n;++i) {
            int j = i + 1, k = n - 1;
            int t = target - nums[i];
            while(j < k) {
                if(nums[j] + nums[k] == t) return target;
                else if(nums[j] + nums[k] > t) {
                    if(diff > nums[j] + nums[k] - t) {
                        diff = nums[j] + nums[k] - t;
                        ret = nums[i] + nums[j] + nums[k];
                    }
                    k--;
                } else if(nums[j] + nums[k] < t) {
                    if(diff > t - nums[j] - nums[k]) {
                        diff = t - nums[j] - nums[k];
                        ret = nums[i] + nums[j] + nums[k];
                    }
                    j++;
                }
            }
        }
        
        return ret;
    }
};