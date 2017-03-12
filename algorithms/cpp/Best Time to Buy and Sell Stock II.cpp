class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int ret = 0;
        int n = prices.size();
        if(n == 0 || n == 1) return ret;
        
        int minp = prices[0];
        for(int i = 1;i < n;++i) {
            if(prices[i] > minp) {
                ret += prices[i] - minp;
            } 
            minp = prices[i];
        }
        return ret;
    }
};