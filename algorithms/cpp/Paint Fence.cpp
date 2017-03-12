class Solution {
public:
    int numWays(int n, int k) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return k;
        }
        
        int s = 0;
        int d = k;
        
        for(int i = 2;i <= n;++i) {
            int ns = d;
            int nd = (d + s) * (k - 1);
            
            s = ns;
            d = nd;
        }
        
        return s + d;
    }
};