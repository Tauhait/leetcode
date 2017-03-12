class Solution {
public:
    int threeSumSmaller(vector<int>& nums, int target) {
        if(nums.size() < 3) return 0;
        sort(nums.begin(), nums.end());
        int ret = 0;
        for(int i = 0;i < nums.size();++i) {
            int val = target - nums[i];
            
            int j = i + 1, k = nums.size() - 1;
            while(j < k) {
                if(nums[j] + nums[k] >= val) {
                    k--;
                }
                else { //if(nums[j] + nums[k] < val) {
                    ret += k - j;
                    j++;
                }
            }
        }

        return ret;
    }
};