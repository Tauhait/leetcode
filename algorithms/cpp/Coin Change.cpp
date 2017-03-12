class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if(amount <= 0) {
            return 0;
        }
        
        vector<int> opt(amount + 1, INT_MAX - 5);
        opt[0] = 0;
        for(int i = 1;i <= amount;++i) {
            for(size_t j = 0;j < coins.size();++j) {
                if(i >= coins[j]) {
                    opt[i] = min(opt[i], opt[i - coins[j]] + 1);
                }
            }
        }
        
        if(opt[amount] == INT_MAX - 5) return -1;
        
        return opt[amount];
    }
};