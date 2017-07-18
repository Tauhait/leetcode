public class Solution {
    private boolean canAchieve(int[] nums, double mid, int k) {
        double[] b = new double[nums.length];
        for(int i = 0;i < nums.length;++i) {
            b[i] = nums[i] - mid;
        }
        
        double sum = 0;
        for(int i = 0;i < k;++i) {
            sum += b[i];
        }
        if(sum >= 0) {
            return true;
        }
        
        double minSum = 0;
        double pre = 0;
        for(int i = k;i < nums.length;++i) {
            sum += b[i];
            pre += b[i - k];
            minSum = Math.min(minSum, pre);
            if(sum >= minSum) {
                return true;
            }
        }
        return false;
    }
    
    public double findMaxAverage(int[] nums, int k) {
        /* find the maximum avg with at least k elements
           the average for any number of elements should be in [minNum, maxNum]
           we could use binary search to check each value could achieve or not
           
           for a perticular value mid, let say a_i + a_{i+1} + ... + a_j >= (j - i + 1) * mid,
           for j - i + 1 >= k, then mid could achieve
           a_i - mid + a_{i+1} - mid + ... + a_j - mid >= 0,
           
           if we say b[j] = a[i] - mid
           then if we could find a subarray in b whose sum is greater than 0 and contains more than k 
           elements, then mid could achieve
           b_i + b_{i+1} + ... + b_j >= 0, if we find the maximum sum of sumarray with more than k elements
           larger than 0, then mid could achieve
           the maximum sum of subarray end at i is the sum from 0 to i substract the min sum from 0 to some point
        */
        
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;++i) {
            minValue = Math.min(minValue, nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
        }
        
        double l = minValue;
        double h = maxValue;
        while(h - l > 0.00001) {
            double mid = (l + h) * 0.5;
            if(canAchieve(nums, mid, k)) {
                l = mid;
            } else {
                h = mid;
            }
        }
        return l;
    }
}