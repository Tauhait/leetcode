public class Solution {
    private int fun(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
    
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        double mid = - b / (double) (2 * a);
        int n = nums.length;
        if(n == 0) {
            return new int[0];
        }
        double minDis = Double.MAX_VALUE;
        int id = -1;
        for(int i = 0;i < n;++i) {
            if(Math.abs(nums[i] - mid) < minDis) {
                minDis = Math.abs(nums[i] - mid);
                id = i;
            }
        }
        
        int i = id;
        int j = i + 1;
        int k = 0;
        int[] ret = new int[n];
        while(i >= 0 && j < n) {
            if(Math.abs(nums[i] - mid) < Math.abs(nums[j] - mid)) {
                ret[k] = fun(a, b, c, nums[i]);
                k++;
                i--;
            } else {
                ret[k] = fun(a, b, c, nums[j]);
                k++;
                j++;
            }
        }
        while(i >= 0) {
            ret[k] = fun(a, b, c, nums[i]);
            k++;
            i--;
        }
        while(j < n) {
            ret[k] = fun(a, b, c, nums[j]);
            k++;
            j++;
        }
        
        if(a < 0 || (a == 0 && b < 0)) {
            for(int l = 0;l < n / 2;++l) {
                int t = ret[l];
                ret[l] = ret[n - 1 -l];
                ret[n - 1 - l] = t;
            }
        }
        
        return ret;
    }
}