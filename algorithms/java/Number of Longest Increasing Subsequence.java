class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n <= 1) return n;
        int[] opt = new int[n];
        int[] ways = new int[n];
        Arrays.fill(opt, 1);
        Arrays.fill(ways, 1);
        
        for(int i = 1;i < n;++i) {
            for(int j = 0;j < i;++j) {
                if(nums[i] > nums[j]) {
                    if(1 + opt[j] > opt[i]) {
                        opt[i] = 1 + opt[j];
                        ways[i] = ways[j];
                    } else if(1 + opt[j] == opt[i]) {
                        ways[i] += ways[j];
                    }
                }
            }
        }

        int maxLen = 1;
        for(int i = 0;i < n;++i) {
            maxLen = Math.max(maxLen, opt[i]);
        }
    
        int ans = 0;
        for(int i = 0;i < n;++i) {
            if(opt[i] == maxLen) ans += ways[i];
        }
        return ans;        
    }
}