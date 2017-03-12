class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        if(n == 0 || n == 1) return n;
        
        vector<int> f(n, 1);
        f[0] = 1;
        for(int i = 1;i < n;++i) {
            for(int j = 0;j < i;++j) {
                if(nums[j] < nums[i]) {
                    f[i] = max(f[i], f[j] + 1);
                }
            }
        }
        
        int max_len = 1;
        for(int i = 0;i < n;++i) {
            max_len = max(max_len, f[i]);
        }
        return max_len;
    }
};