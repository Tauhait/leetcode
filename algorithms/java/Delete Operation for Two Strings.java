public class Solution {
    private int minThree(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
    
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] opt = new int[m + 1][n + 1];
        opt[0][0] = 0;
        for(int i = 1;i <= m;++i) {
            opt[i][0] = i;
        }
        for(int i = 1;i <= n;++i) {
            opt[0][i] = i;
        }
        
        for(int i = 1;i <= m;++i) {
            for(int j = 1;j <= n;++j) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    opt[i][j] = minThree(opt[i - 1][j - 1], opt[i][j - 1] + 1, opt[i - 1][j] + 1);
                } else {
                    opt[i][j] = minThree(opt[i - 1][j - 1] + 2, opt[i][j - 1] + 1, opt[i - 1][j] + 1);
                }
            }
        }
        
        return opt[m][n];
    }
}