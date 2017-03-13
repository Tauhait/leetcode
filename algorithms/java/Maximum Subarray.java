public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int maxOpt = nums[0];
        int opt = nums[0];
        for(int i = 1;i < nums.length;++i) {
            if(opt > 0) opt = nums[i] + opt;
            else opt = nums[i];
            
            maxOpt = Math.max(opt, maxOpt);
        }
        
        return maxOpt;
    }
}