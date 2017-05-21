public class Solution {
    public int numWays(int n, int k) {
        if(n < 0 || k < 0) {
            throw new IllegalArgumentException();
        }
        if(n == 0 || k == 0) {
            return 0;
        }
        if(n == 1) {
            return k;
        }
        if(n == 2) {
            return k * k;
        }
        
        // opt[i][0] is the number of paints with different color as the previous one
        // opt[i][0] is the number of paints with the same color as the previous one
        int[][] opt = new int[n + 1][2];
        opt[0][0] = 0;
        opt[0][0] = 0;
        opt[1][0] = k;
        opt[1][1] = 0;

        
        for(int i = 2;i <= n;++i) {
            opt[i][0] = (opt[i - 1][0] + opt[i - 1][1]) * (k - 1);
            opt[i][1] = opt[i - 1][0];
        }
        
        return opt[n][0] + opt[n][1];
    }
}