public class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if(n == 0) {
            return 0;
        }
        // opt[i][j] is the cost from house 0 to i with color j for house i
        int[][] opt = new int[n][3];
        for(int j = 0;j < 3;++j) {
            opt[0][j] = costs[0][j];
        }
        for(int i = 1;i < n;++i) {
            opt[i][0] = costs[i][0] + Math.min(opt[i - 1][1], opt[i - 1][2]); 
            opt[i][1] = costs[i][1] + Math.min(opt[i - 1][0], opt[i - 1][2]); 
            opt[i][2] = costs[i][2] + Math.min(opt[i - 1][0], opt[i - 1][1]); 
        }
        
        return Math.min(opt[n - 1][0], Math.min(opt[n - 1][1], opt[n - 1][2]));
    }
}