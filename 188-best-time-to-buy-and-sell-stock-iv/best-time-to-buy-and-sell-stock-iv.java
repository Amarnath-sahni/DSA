class Solution {
    public int maxProfit(int k, int[] prices) {
          int n = prices.length;


        if(n == 0) {
            return 0;
        }


        // If transactions are unlimited
        if(k >= n / 2) {

            int profit = 0;


            for(int i = 1; i < n; i++) {

                if(prices[i] > prices[i-1]) {

                    profit += prices[i] - prices[i-1];
                }
            }


            return profit;
        }



        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];


        Arrays.fill(
            buy,
            Integer.MIN_VALUE
        );



        for(int price : prices) {


            for(int transaction = 1; transaction <= k; transaction++) {


                // Buy stock
                buy[transaction] = Math.max(
                    buy[transaction],
                    sell[transaction - 1] - price
                );


                // Sell stock
                sell[transaction] = Math.max(
                    sell[transaction],
                    buy[transaction] + price
                );
            }
        }


        return sell[k];
    }
}