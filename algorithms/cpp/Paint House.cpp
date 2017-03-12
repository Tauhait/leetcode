class Solution {
public:
    int minCost(vector<vector<int> >& costs) {
        int n = costs.size();
        if(n == 0) {
            return 0;
        }
        vector<vector<int> > opt(n, vector<int>(3, INT_MAX));
        
        for(int i = 0;i < 3;++i) {
            opt[0][i] = costs[0][i];
        }
        
        for(int i = 1;i < n;++i) {
            opt[i][0] = min(opt[i - 1][1], opt[i - 1][2]) + costs[i][0];
            opt[i][1] = min(opt[i - 1][0], opt[i - 1][2]) + costs[i][1];
            opt[i][2] = min(opt[i - 1][0], opt[i - 1][1]) + costs[i][2];
        }
        
        return min(opt[n - 1][0], min(opt[n - 1][1], opt[n - 1][2]));
    }
};