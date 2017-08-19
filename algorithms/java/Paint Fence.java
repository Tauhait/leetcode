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
        // opt[i][1] is the number of paints with the same color as the previous one
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
//////////////////////////////
public class Solution {
    public int numWays(int n, int k) {
        if(n < 0 || k < 0) throw new IllegalArgumentException();
        if(n == 0 || k == 0) return 0;
        
        if(n == 1) return k;
        if(n == 2) return k * k;
        
        // cur0 is the number of paints with different color as the previous one
        // cur1 is the number of paints with the same color as the previous one
        int cur0 = k, cur1 = 0;
        for(int i = 2;i <= n;++i) {
            int ncur0 = (cur0 + cur1) * (k - 1);
            int ncur1 = cur0;
            
            cur0 = ncur0;
            cur1 = ncur1;
        }
        
        return cur0 + cur1;
    }
}