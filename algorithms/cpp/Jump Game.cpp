class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        if(n == 0) return false;
        
        vector<int> reach(n, 0);
        reach[0] = 1;
        int k = 1;
        for(int i = 0;i < n - 1;++i) {
            if(reach[i] == 1) {
                k = max(k, i + 1);
                while(k <= i + nums[i]) {
                    reach[k] = 1;
                    if(k == n - 1) return true;
                    k++;
                }
            }
        }
        
        return reach[n - 1] == 1;
    }
};