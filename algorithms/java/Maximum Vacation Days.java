public class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;
        int K = days[0].length;
        
        int[][] opt = new int[K][N];
        for(int i = 0;i < K;++i) {
            Arrays.fill(opt[i], -1);
        }
        
        opt[0][0] = days[0][0];
        for(int i = 1;i < N;++i) {
            if(flights[0][i] == 1) {
                opt[0][i] = days[i][0];
            }
        }
        
        for(int k = 1; k < K;++k) {
            for(int c = 0;c < N;++c) {
                if(opt[k - 1][c] != -1) {
                    opt[k][c] = Math.max(opt[k][c], opt[k - 1][c] + days[c][k]);
                }
                
                for(int p = 0;p < N;++p) {
                    if(opt[k - 1][p] != -1 && flights[p][c] == 1) {
                        opt[k][c] = Math.max(opt[k][c], opt[k - 1][p] + days[c][k]);
                    }
                }
            }
        }
        
        int ret = 0;
        for(int i = 0;i < N;++i) {
            ret = Math.max(ret, opt[K - 1][i]);
        }
        return ret;
    }
}