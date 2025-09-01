class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int max = amount+1;

        int[][] dp = new int[n + 1][amount + 1];

        // initialize
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = max; // 0 coins can't make positive amount
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0; // to make amount 0, need 0 coins
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=amount; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j-coins[i - 1]]);
                }else{
                     dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount] > amount ? -1 :dp[n][amount];
    }
}