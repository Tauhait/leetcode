class Solution {
public:
    vector<vector<int> > ret;
    vector<int> used;
    
    void dfs(const int& n, const int& index, vector<int>& cur, const vector<int>& nums) {
        if(n == index) {
            ret.push_back(cur);
            return;
        }
        
        for(int i = 0;i < n;++i) {
            if(used[i] == 0) {
                cur[index] = nums[i];
                used[i] = 1;
                dfs(n, index + 1, cur, nums);
                used[i] = 0;
            }
        }
    }
    
    vector<vector<int> > permute(vector<int>& nums) {
        int n = nums.size();
        for(int i = 0;i < n;++i) {
            used.push_back(0);
        }
        
        vector<int> cur(n, 0);
        dfs(n, 0, cur, nums);
        
        return ret;
    }
};