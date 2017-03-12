class Solution {
public:
    int uniquePaths(int m, int n) {
        m--;
        n--;
        if(m < n) swap(m, n);
        
        vector<int> f(n + 1, 0);
        int paths = 1;
        for(int i = m + n;i >= m + 1;--i) {
            paths *= i;
            for(int j = n;j >= 2;--j) {
                if(f[j] == 0 && paths % j == 0) {
                    paths /= j;
                    f[j] = 1;
                }
            }
        }
        
        return paths;
    }
};