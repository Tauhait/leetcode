class Solution {
public:
    int minDistance(string s, string t) {
        int ls = s.size(), lt = t.size();
        vector<vector<int> > opt(ls + 1, vector<int>(lt + 1, INT_MAX));
        opt[0][0] = 0;
        for(int i = 1;i <= ls;++i) {
            opt[i][0] = i;
        }
        for(int i = 1;i <= lt;++i) {
            opt[0][i] = i;
        }
        
        for(int i = 1;i <= ls;++i) {
            for(int j = 1;j <= lt;++j) {
                if(s[i - 1] == t[j - 1]) {
                    opt[i][j] = min(opt[i][j], opt[i - 1][j - 1]);
                }
                opt[i][j] = min(opt[i][j], opt[i - 1][j - 1] + 1);
                opt[i][j] = min(opt[i][j], opt[i - 1][j] + 1);
                opt[i][j] = min(opt[i][j], opt[i][j - 1] + 1);
            }
        }
        return opt[ls][lt];
        
    }
};