public class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if(n == 0 || n == 1) return n;
        
        Arrays.sort(pairs, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int[] opt = new int[n];
        Arrays.fill(opt, 1);
        for(int i = 1;i < n;++i) {
            for(int j = 0;j < i;++j) {
                if(pairs[j][1] < pairs[i][0])
                    opt[i] = Math.max(opt[i], opt[j] + 1);
            }
        }
        
        int ret = 0;
        for(int i = 0;i < n;++i) {
            ret = Math.max(ret, opt[i]);
        }
        return ret;          
    }
}