class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        if(nums.size() == 0) return 0;
        int start = 0;
        int sum = 0;
        int ret = INT_MAX;
        for(int i = 0;i < nums.size();++i) {
            if(sum + nums[i] > nums[i]) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
                start = i;
            }
            if(sum >= s) {
                while(sum - nums[start] >= s) {
                    sum = sum - nums[start];
                    start++;
                }
                ret = min(ret, i - start + 1);
            }
        }
        
        return ret == INT_MAX ? 0 : ret;
    }
};