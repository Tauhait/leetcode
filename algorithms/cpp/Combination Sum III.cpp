class Solution {
public:
    vector<vector<int> > ret;
    vector<int> f;
    void dfs(int k, int d, const int& n, int cur_sum) {
        
        if(cur_sum > n) return ;
        if(k < 0) return ;
        if(k == 0 && cur_sum == n) {
            vector<int> sol;
            for(int i = 1;i <= 9;++i) {
                if(f[i]) sol.push_back(i);
            }
            ret.push_back(sol);
            return ;
        }
        if(k == 0 && cur_sum != n) return ;
        if(k != 0 && cur_sum == n) return ;
        
        if(cur_sum + d <= n && d <= 9) {
            f[d] = 1;
            dfs(k - 1, d + 1, n, cur_sum + d);
            f[d] = 0;
        }
        if(d + 1 <= 9) {
            dfs(k, d + 1, n, cur_sum);
        }
    }
    
    vector<vector<int> > combinationSum3(int k, int n) {
        ret.clear();
        if(k == 0 && n == 0) return ret;
        
        f.resize(10);
        for(int i = 1;i <= 9;++i) {
            f[i] = 0;
        }
        dfs(k, 1, n, 0);
        
        return ret;
    }
};