public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n < 3) {
            return 0;
        }
        int[] left = new int[n];
        left[0] = 0;
        for(int i = 1;i < n;++i) {
            left[i] = Math.max(height[i - 1], left[i - 1]);
        }
        
        int ret = 0;
        int rightMax = 0;
        for(int i = n - 1;i >= 0;--i) {
            int h = Math.min(left[i], rightMax) - height[i];
            ret += Math.max(0, h);
            rightMax = Math.max(rightMax, height[i]);
        }
        return ret;
    }
}