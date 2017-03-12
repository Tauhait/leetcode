class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if(s3.size() != s1.size() + s2.size()) return false;

        
        int m = s1.size(), n = s2.size();
        vector<vector<int> > f(m + 1, vector<int>(n + 1, 0));
        
        f[0][0] = 1;
        for(int i = 1;i <= m;++i) {
            f[i][0] = s1.substr(0, i) == s3.substr(0, i) ? 1 : 0;
        }
        for(int i = 1; i <= n;++i) {
            f[0][i] = s2.substr(0, i) == s3.substr(0, i) ? 1 : 0;
        }
        
        for(int i = 1; i <= m;++i) {
            for(int j = 1;j <= n;++j) {
                f[i][j] = max((f[i-1][j] && s1[i - 1] == s3[i + j - 1]), (f[i][j - 1] && s2[j - 1] == s3[i + j - 1]));
            }
        }
        
        return f[m][n] == 1;
    }
};