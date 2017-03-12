class Solution {
public:
    int numSquares(int n) {
        vector<int> f(n + 1, INT_MAX);
        f[0] = 0;
        f[1] = 1;
        
        for(int i = 2;i <= n;++i) {
            for(int j = 1;j <= int(sqrt(i));++j) {
                f[i] = min(f[i], f[i - j * j] + 1);
            }
        }
        
        return f[n];
    }
};