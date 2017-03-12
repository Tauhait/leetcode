
class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n == 0) return 0;
        
        vector<int> opt(n);
        opt[0] = 0;
        int k = 1;
        for(int i = 0;i <= n - 1;++i) {
            k = max(k, i + 1);
            while(k < n && k <= i + nums[i]) {
                opt[k] = opt[i] + 1;
                k++;
            }
        }
        
        return opt[n - 1];
    }
};