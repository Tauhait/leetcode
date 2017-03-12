class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        if(m == 0) return 0;
        int n = grid[0].size();
        
        vector<int> opt(n, INT_MAX);
        opt[0] = grid[0][0];
        for(int i = 1;i < n;++i) {
            opt[i] = opt[i - 1] + grid[0][i];
        }
        
        for(int i = 1;i < m;++i) {
            opt[0] = opt[0] + grid[i][0];
            for(int j = 1;j < n;++j) {
                opt[j] = min(opt[j - 1], opt[j]) + grid[i][j];
            }
        }
        
        return opt[n - 1];
    }
};