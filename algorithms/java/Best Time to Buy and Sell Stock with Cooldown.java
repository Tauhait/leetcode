class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2) return 0;
        int[] sell = new int[n]; // sell[i] is the maximum profit end with i (sell or not)
        sell[0] = 0;
        sell[1] = Math.max(sell[0], prices[1] - prices[0]);
        for(int i = 2;i < n;++i) {
            sell[i] = sell[i - 1];
            for(int j = i - 1;j >= 0;--j) {
                if(prices[i] > prices[j]) {
                    if(j >= 2)
                        sell[i] = Math.max(sell[i], prices[i] - prices[j] + sell[j - 2]);
                    else
                        sell[i] = Math.max(sell[i], prices[i] - prices[j]);
                }
            }
        }
        return sell[n - 1];
    }
}