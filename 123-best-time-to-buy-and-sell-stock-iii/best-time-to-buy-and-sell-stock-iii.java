class Solution {
    public int maxProfit(int[] prices) {
         if (prices == null || prices.length == 0) return 0;

        // Initialize:
        int buy1 = -prices[0];   // max balance after first buy (negative)
        int sell1 = 0;          // max profit after first sell
        int buy2 = Integer.MIN_VALUE; // max balance after second buy
        int sell2 = 0;          // max profit after second sell (answer)

        for (int i = 1; i < prices.length; i++) {
            int p = prices[i];

            // update in order so we use previous-stage values correctly
            buy1 = Math.max(buy1, -p);           // best of keeping previous buy1 or buying today
            sell1 = Math.max(sell1, buy1 + p);   // sell first time today
            buy2 = Math.max(buy2, sell1 - p);    // buy second time using profit from sell1
            sell2 = Math.max(sell2, buy2 + p);   // sell second time today
        }

        return sell2;
    }
}