public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] opt = new int[amount + 1];
        Arrays.fill(opt, -1);
        
        opt[0] = 0;
        for(int i = 1;i <= amount;++i) {
            for(int j = 0;j < coins.length;++j) {
                if(i >= coins[j] && opt[i - coins[j]] != -1){
                    if(opt[i] == -1) {
                        opt[i] = opt[i - coins[j]] + 1; 
                    } else {
                        opt[i] = Math.min(opt[i], opt[i - coins[j]] + 1);
                    }
                }
            }
        }
        
        return opt[amount];
    }
}