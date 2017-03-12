class Solution {
public:
    vector<vector<int> > ret;
    
    void dfs(const int& n, const int& start, vector<int>& cur) {
        if(n == 1) {
            if(cur.size() > 1) {
                ret.push_back(cur);
            }
            return ;
        }
        if(n < start) return ;
      
        for(int i = start;i <= n;++i) {
            if(n % i == 0) {
                cur.push_back(i);
                dfs(n / i, i, cur);
                cur.pop_back();
            }
        }
    }
    
    vector<vector<int> > getFactors(int n) {
        vector<int> cur;
        dfs(n, 2, cur);
        
        return ret;
    }
};