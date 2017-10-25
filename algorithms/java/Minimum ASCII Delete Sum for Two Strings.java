class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] opt = new int[m + 1][n + 1];
        opt[0][0] = 0;
        for(int i = 1;i <= m;++i)
            opt[i][0] = opt[i - 1][0] + s1.charAt(i - 1);
        for(int i = 1;i <= n;++i)
            opt[0][i] = opt[0][i - 1] + s2.charAt(i - 1);
        
        
        for(int i = 1;i <= m;++i) {
            for(int j = 1;j <= n;++j) {
                opt[i][j] = Math.min(opt[i - 1][j] + s1.charAt(i - 1), opt[i][j - 1] + s2.charAt(j - 1));
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) opt[i][j] = Math.min(opt[i][j], opt[i - 1][j - 1]);
            }
        }
        return opt[m][n];
    }
}

////// O(n) space
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] opt = new int[n + 1];
        opt[0] = 0;
        for(int i = 1;i <= n;++i)
            opt[i] = opt[i - 1] + s2.charAt(i - 1);
        
        
        for(int i = 1;i <= m;++i) {
            int[] opt2 = new int[n + 1];
            opt2[0] = opt[0] + s1.charAt(i - 1);
            for(int j = 1;j <= n;++j) {
                opt2[j] = Math.min(opt[j] + s1.charAt(i - 1), opt2[j - 1] + s2.charAt(j - 1));
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) opt2[j] = Math.min(opt2[j], opt[j - 1]);
            }
            opt = opt2;
        }
        return opt[n];
    }
}