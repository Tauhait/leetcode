public class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) return 1;
        int pre1 = 1;
        int pre2 = 1;
        int cur = 0;
        
        for(int i = 2;i <= n;++i) {
            cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        
        return cur;
    }
}