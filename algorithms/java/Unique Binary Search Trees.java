public class Solution {
    public int numTrees(int n) {
        int[] opt = new int[Math.max(3, n + 1)];
        opt[0] = 1;
        opt[1] = 1;
        for(int i = 2;i <= n;++i) {
            opt[i] = 0;
            for(int j = 0;j <= i - 1;++j) {
                opt[i] += opt[j] * opt[i - j - 1];
            }
        }
        
        return opt[n];
    }
}