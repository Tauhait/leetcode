class Solution {
public:
    int countPrimes(int n) {
        if(n == 0 || n == 1 || n == 2) return 0;
        vector<int> f(n, 1);
        f[1] = 0;
        int ret = 0;
        for(int i = 2;i < n;++i) {
            if(f[i] == 0) continue;
            ret++;
            for(int j = i + i;j < n;j += i) {
                f[j] = 0;
            }
        }
        
        return ret;
    }
};