class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 0) throw new IllegalArgumentException();
        if(n == 1) return nums[0];
        
        int[] minProd = new int[n];
        int[] maxProd = new int[n];
        
        minProd[0] = nums[0];
        maxProd[0] = nums[0];
        
        for(int i= 1;i < n;++i) {
            if(nums[i] >= 0) {
                maxProd[i] = Math.max(nums[i], nums[i] * maxProd[i - 1]);
                minProd[i] = Math.min(nums[i], nums[i] * minProd[i - 1]);
            } else {
                maxProd[i] = Math.max(nums[i], nums[i] * minProd[i - 1]);
                minProd[i] = Math.min(nums[i], nums[i] * maxProd[i - 1]);
            }
        }
        int ret = Integer.MIN_VALUE;
        for(int i = 0;i < n;++i) {
            ret = Math.max(ret, maxProd[i]);
        }
        return ret;
    }
}