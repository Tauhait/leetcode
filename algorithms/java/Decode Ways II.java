public class Solution {
    private static final int MOD = 1000000007;
    
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0) return 0;
        
        long[] opt = new long[n + 1];
        opt[0] = 1;
        opt[1] = 0;
        if(s.charAt(0) == '*') opt[1] = 9;
        else if(s.charAt(0) >= '1' && s.charAt(0) <= '9') opt[1] = 1;
        
        for(int i = 2;i <= n;++i) {
            char c = s.charAt(i - 1);
            char cp = s.charAt(i - 2);
            if(c == '*') {
                opt[i] = (9 * opt[i - 1]) % MOD; // itself
                if(cp == '1')      opt[i] += (opt[i - 2] * 9) % MOD; // 0 - 9
                else if(cp == '2') opt[i] += (opt[i - 2] * 6) % MOD; // 0 - 6
                else if(cp == '*') opt[i] += (opt[i - 2] * (9 + 6)) % MOD; //
            } else {
                if(c >= '1' && c <= '9') opt[i] = opt[i - 1]; // itself
                if(cp == '1') opt[i] += opt[i - 2];
                else if(cp == '2' && c >= '0' && c <= '6') opt[i] += opt[i - 2];
                else if(cp== '*') {
                    opt[i] += opt[i - 2];
                    opt[i] %= MOD;
                    if(c >= '0' && c <= '6') opt[i] += opt[i - 2];
                }
            }
            opt[i] %= MOD;
        }
        return (int) opt[n];
    }
}