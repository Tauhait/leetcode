public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if(n == 0) {
            return res;
        }
        
        // res[i] = nums[i + 1] * nums[i + 2] * ... * nums[n - 1]        
        res[n - 1] = 1;
        for(int i = n - 2;i >= 0;--i) {
            res[i] = nums[i + 1] * res[i + 1];
        }
    
        int product = 1;
        for(int i = 0;i < n;++i) {
            res[i] = product * res[i];
            product *= nums[i];
        }
    
        return res;
    }
}