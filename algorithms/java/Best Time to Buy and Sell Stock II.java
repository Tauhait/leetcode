public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int profit = 0;
        int cur = prices[0];
        for(int i = 1;i < prices.length;++i) {
            if(prices[i] > cur) {
                profit += prices[i] - cur;
                cur = prices[i];
            } else {
                cur = prices[i];
            }
        }
        
        return profit;
    }
}