public class Solution {
    private static final int MOD = 1000000007;
    
    public int findDerangement(int n) {
        /*
        two cases:
        (1) n-th number exchange position with i-th number
            which is i-th number put to n-th position, and n-th number put into i-th postion
            (n-1) * f[n - 2]
        (2) select one number from 1 to n - 1 and put it in n-th position
            then, the rest n - 2 number and n-th number form a n - 1 subproblem
            because n-th number could not put in i-th position
            (n-1) * f[n - 1]
        */    
        long[] f = new long[Math.max(5, n + 1)];
        f[0] = 1;
        f[1] = 0;
        f[2] = 1;
        f[3] = 2;
        for(int i = 4;i <= n;++i) {
            f[i] =(((i - 1) * f[i - 2]) % MOD + ((i - 1) * f[i - 1]) % MOD) % MOD;
        }
        return (int)f[n];        
    }
}