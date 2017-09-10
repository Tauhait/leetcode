class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int preZero = -1;
        int curZero = -1;
        int ret = 0;
        int n = nums.length;
        for(int i = 0;i < n;++i) {
            if(nums[i] == 0) {
                if(curZero == -1) {
                    curZero = i;
                } else {
                    if(preZero == -1) ret = Math.max(ret, i);
                    else ret = Math.max(ret, i - 1 - (preZero + 1) + 1);
                    preZero = curZero;
                    curZero = i;
                    
                }
            }
        }
        if(preZero == -1) return n;
        ret = Math.max(ret, n - 1 - (preZero + 1) + 1);
        return ret;        
    }
}