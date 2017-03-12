class Solution {
public:
    vector<vector<int> > ret;
    void dfs(const int& d, const int& nk, const int& k, const int& n, vector<int>& cur) {
        if(nk == k) {
            ret.push_back(cur);
            return ;
        }
        if(d > n) return ;
        
        cur.push_back(d);
        dfs(d + 1, nk + 1, k, n, cur);
        cur.pop_back();
        
        dfs(d + 1, nk, k, n, cur);
    }
    
    vector<vector<int> > combine(int n, int k) {
        vector<int> cur;
        dfs(1, 0, k, n, cur);
        
        return ret;    
    }
};