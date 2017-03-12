class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n == 0) return 0;
        
        vector<int> f(n, 0);
        f[0] = nums[0];
        f[1] = nums[1];
        for(int i = 2;i < n;++i) {
            for(int j = 0;j <= i - 2;++j) {
                f[i] = max(f[i], f[j] + nums[i]);
            }
        }
        
        int ret = 0;
        for(int i = 0;i < n;++i) {
            ret = max(f[i], ret);
        }
        
        return ret;
    }
};