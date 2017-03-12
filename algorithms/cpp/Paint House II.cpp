class Solution {
public:
    int minCostII(vector<vector<int> >& costs) {
        int n = costs.size();
        if(n == 0) {
            return 0;
        }
        int k = costs[0].size();
        
        vector<vector<int> > opt(n, vector<int>(k, INT_MAX));
        
        for(int i = 0;i < k;++i) {
            opt[0][i] = costs[0][i];
        }
        
        for(int i = 1;i < n;++i) {
            int mina = INT_MAX, minb = INT_MAX, minaid = -1, minbid = -1;
            for(int j = 0;j < k;++j) {
                if(opt[i - 1][j] < mina) {
                    if(mina < minb) {
                        minb = mina;
                        minbid = minaid;
                    }
                    
                    mina = opt[i - 1][j];
                    minaid = j;
                } else if(opt[i - 1][j] < minb) {
                    minb = opt[i - 1][j];
                    minbid = j;
                }
            }
            
            for(int j = 0;j < k;++j) {
                if(minaid == j) {
                    opt[i][j] = minb + costs[i][j];
                } else {
                    opt[i][j] = mina + costs[i][j];
                }
            }
        }
        
        int ret = INT_MAX;
        for(int j = 0;j < k;++j) {
            ret = min(ret, opt[n - 1][j]);   
        }
        
        return ret;
    }
};