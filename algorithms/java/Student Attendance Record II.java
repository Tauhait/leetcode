/*
f[i][0] is the number of possible end with P and without A
f[i][1] is the number of possible end with L and without A

t[i][0] is the number of possible end with P and with one A
t[i][1] is the number of possible end with L and with one A
t[i][2] is the number of possible end with A and with one A

f[i][0] = f[i - 1][0] + f[i - 1][1]
f[i][1] = f[i - 1][0] + f[i - 2][0]

t[i][0] = t[i - 1][0] + t[i - 1][1] + t[i - 1][2]
t[i][1] = t[i - 1][0] + t[i - 1][2] + t[i - 2][0] + t[i - 2][2]
t[i][2] = f[i - 1][0] + f[i - 1][1]
*/
class Solution {
    private static final int MOD = 1000000007;

    public int checkRecord(int n) {        
        int[][] f = new int[Math.max(4, n + 1)][2];
        int[][] t = new int[Math.max(4, n + 1)][3];

        f[0][0] = 1;
        f[0][1] = 1;
        f[1][0] = 1;
        f[1][1] = 1;

        t[0][0] = 0;
        t[0][1] = 0;
        t[0][2] = 0;
        t[1][0] = 0;
        t[1][1] = 0;
        t[1][2] = 1;

        for(int i = 2;i <= n;++i) {
            f[i][0] = f[i - 1][0] + f[i - 1][1];
            f[i][1] = f[i - 1][0] + f[i - 2][0];

            t[i][0] = (t[i - 1][0] + t[i - 1][1]) % MOD + t[i - 1][2];
            t[i][1] =  (t[i - 1][0] + t[i - 1][2]) % MOD + (t[i - 2][0] + t[i - 2][2]) % MOD;
            t[i][2] = f[i - 1][0] + f[i - 1][1];

            f[i][0] %= MOD;f[i][1] %= MOD;
            t[i][0] %= MOD;t[i][1] %= MOD;t[i][2] %= MOD;
        }
        return (((f[n][0] + f[n][1]) % MOD + (t[n][0] + t[n][1]) % MOD) % MOD + t[n][2]) % MOD;
    }
}