class Solution {
public:
    int climbStairs(int n) {
        vector<int> reach(n + 1, 0);
        reach[0] = 1;
        reach[1] = 1;
        reach[2] = 2;
        for(int i = 3;i <= n;++i) {
            reach[i] = reach[i - 1] + reach[i - 2];
        }
        
        return reach[n];
    }
};