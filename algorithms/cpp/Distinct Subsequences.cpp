class Solution {
public:
    int numDistinct(string s, string t) {
        int m = s.size();
        int n = t.size();
        vector<vector<int> > opt(m + 1, vector<int>(n + 1, 0));
        for(int i = 0;i < m + 1;++i) {
            opt[i][0] = 1;
        }
        for(int j = 1;j < n + 1;++j) {
            opt[0][j] = 0;
        }
        
        for(int i = 1;i <= m;++i) {
            for(int j = 1;j <= n;++j) {
                opt[i][j] = s[i - 1] == t[j - 1] ? opt[i - 1][j] + opt[i - 1][j - 1] : opt[i - 1][j];
            }
        }
        
        return opt[m][n];
    }
};