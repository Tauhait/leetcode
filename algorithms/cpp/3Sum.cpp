class Solution {
public:
    vector<vector<int> > ret;
    vector<vector<int> > threeSum(vector<int>& nums) {
        int n = nums.size();
        if(n < 3) {
            return ret;
        }
        
        sort(nums.begin(), nums.end());
        
        for(size_t i = 0;i < nums.size();++i) {
            if(i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int j = i + 1, k = n - 1;
            while(j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if(s > 0) {
                    k--;
                } else if(s < 0) {
                    j++;
                } else {
                    ret.push_back(vector<int>{nums[i], nums[j], nums[k]});
                    j++;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    k--;
                    while(j < k && nums[k] == nums[k + 1]) k++;
                }
            }
        }
        
        return ret;
    }
};