public class Solution {
    public int uniquePaths(int m, int n) {
        if(m < n) {
            int t = m;
            m = n;
            n = t;
        }
        m--;
        n--;
        if(m + n <= 1) return 1;
        
        long s = 1;
        boolean[] used = new boolean[n + 1];
        Arrays.fill(used, false);
        for(int i = m + 1;i <= m + n;++i) {
            // product divide n!
            s *= (long) i;
            for(int j =  n;j >= 2;--j) {
                if(used[j] == false && s %  (long) j == 0) {
                    s /= (long) j;
                    used[j] = true;
                }
            }
        }
        
        return (int) s;
    }
}