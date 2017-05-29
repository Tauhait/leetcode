public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int l = ops.length;
        if(l == 0) {
            return m * n;
        }
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for(int i = 0;i < l;++i) {
            if(ops[i][0] == 0 || ops[i][1] == 0) continue;
            minX = Math.min(minX, ops[i][0]);
            minY = Math.min(minY, ops[i][1]);
        }
        
        if(minX == Integer.MAX_VALUE || minY == Integer.MAX_VALUE) {
            return m * n;
        }

        return minX * minY;
    }
}