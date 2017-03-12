class Solution {
public:
    vector<vector<int> > ispalindrome;
    vector<vector<string> > ret;
    string str;
    
    void dfs(const int& d, const int& n, vector<int>& cut_pos) {
        if(d == n) {
            vector<string> sol;
            int l = cut_pos.size();
            if(l == 0) return ;
            for(size_t i = 0;i < l - 1;++i) {
                sol.push_back(str.substr(cut_pos[i], cut_pos[i + 1] - cut_pos[i]));
            } 
            sol.push_back(str.substr(cut_pos[l - 1]));
            ret.push_back(sol);
    
            return ;
        }
        
        for(int i = d;i < n;++i) {
            if(ispalindrome[d][i]) {
                cut_pos.push_back(d);
                dfs(i + 1, n, cut_pos);
                cut_pos.pop_back();
            }
        }
    }
    
    vector<vector<string>> partition(string s) {
        int n = s.size();
        ispalindrome.resize(n);
        for(int i = 0;i < n;++i) {
            ispalindrome[i].resize(n);
        }
        
        for(int i = 0;i < n;++i) {
            ispalindrome[i][i] = 1;
        }
        for(int i = 0;i < n - 1;++i) {
            ispalindrome[i][i + 1] = s[i] == s[i + 1];
        }
        
        for(int l = 3;l <= n;++l) {
            for(int i = 0;i + l - 1 < n;++i) {
                ispalindrome[i][i + l - 1] = ispalindrome[i + 1][i + l - 2] && s[i] == s[i + l - 1];
            }
        }
        
        ret.clear();
        str = s;
        vector<int> cut_pos;
        dfs(0, n, cut_pos);
        
        return ret;
    }
};