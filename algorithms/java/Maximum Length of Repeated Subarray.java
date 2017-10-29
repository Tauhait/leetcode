class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if(m == 0 || n == 0) return 0;
        
        int[][] opt = new int[m + 1][n + 1];
        opt[0][0] = 0;
        for(int i = 1;i < m;++i) opt[i][0] = 0;
        for(int j = 1;j < n;++j) opt[0][j] = 0;
        int ret = 0;
        for(int i = 1;i <= m;++i) {
            for(int j = 1;j <= n;++j) {
                if(A[i - 1] == B[j - 1]) 
                    opt[i][j] = Math.max(opt[i][j], opt[i - 1][j - 1] + 1);
                ret = Math.max(opt[i][j], ret);
            }
        }
        return ret;
    }
}