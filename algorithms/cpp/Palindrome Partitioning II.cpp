class Solution {
public:
    int minCut(string s) {
        int n = s.size();
        if(n == 0 || n == 1) return 0;
        
        vector<vector<int> > ispalindrome(n, vector<int>(n, 0));
        
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
        
        vector<int> opt(n, INT_MAX);
        opt[0] = 0;
        for(int i = 1;i < n;++i) {
            if(ispalindrome[0][i]) {
                opt[i] = 0;
            } else {
                for(int j = i;j >= 1;--j) {
                    if(ispalindrome[j][i]) {
                        opt[i] = min(opt[i], opt[j - 1] + 1);
                    }
                }
            }
        }
        
        return opt[n - 1];
    }
};