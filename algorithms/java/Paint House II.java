public class Solution {
    int[] firstSecondMin(int[] nums) {
        int minF = Integer.MAX_VALUE;
        int minS = Integer.MAX_VALUE;
        int minFID = -1;
        int minSID = -1;
        for(int i = 0;i < nums.length;++i) {
            if(nums[i] <= minF) {
                minS = minF;
                minSID = minFID;
                minF = nums[i];
                minFID = i;
            } else if(nums[i] < minS) {
                minS = nums[i];
                minSID = i;
            }
        }
        
        return new int[]{minFID, minSID};
    }
    
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if(n == 0) {
            return 0;
        }
        int k = costs[0].length;
        if(k == 0) {
            return 0;
        }
        
        int[][] opt = new int[n][k];
        for(int j = 0;j < k;++j) {
            opt[0][j] = costs[0][j];
        }
        for(int i = 1;i < n;++i) {
            int[] ids = firstSecondMin(opt[i - 1]);
            for(int j = 0;j < k;++j) {
                if(ids[0] != j) {
                    opt[i][j] = costs[i][j] + opt[i - 1][ids[0]];
                } else {
                    opt[i][j] = costs[i][j] + opt[i - 1][ids[1]];
                }
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        for(int j = 0;j < k;++j) {
            minCost = Math.min(minCost, opt[n - 1][j]);
        }
        return minCost;
    }
}