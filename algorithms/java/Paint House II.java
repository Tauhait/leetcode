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

//////////////////////////
// O(k) space complexity
class Solution {
    private int[] getFirstSecondMin(int[] nums) {
        int firstID = -1;
        int first = Integer.MAX_VALUE;
        int secondID = -1;
        int second = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length;++i) {
            if(nums[i] < first) {
                if(first < second) {
                    second = first;
                    secondID = firstID;
                }
                first = nums[i];
                firstID = i;
            } else if(nums[i] < second) {
                second = nums[i];
                secondID = i;
            }    
        }
        return new int[]{firstID, first, secondID, second};
    }
    
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;
        int k = costs[0].length;
        if(k == 0) return 0;
        if(n >= 2 && k < 2) return 0;
        
        int[] opt = new int[k];
        for(int i = 0;i < k;++i) opt[i] = costs[0][i];
        int[] cur = new int[k];
        for(int i = 1;i < n;++i) {
            int[] firstSecond = getFirstSecondMin(opt);   
            for(int j = 0;j < k;++j) {
                if(firstSecond[0] != j) cur[j] = opt[firstSecond[0]] + costs[i][j];
                else cur[j] = opt[firstSecond[2]] + costs[i][j];
            }
            for(int j = 0;j < k;++j) opt[j] = cur[j];
        }
        
        int ret = Integer.MAX_VALUE;
        for(int i = 0;i < k;++i) ret = Math.min(opt[i], ret);
        return ret;
    }
}