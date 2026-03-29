class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyDay = prices[0];

        int idx = 1;
        for(int i=1; i<prices.length; i++){

            if(prices[i] > prices[i-1]){
                profit +=  prices[i] - buyDay;
            }
            
            buyDay = prices[i];
        }

        return profit;
    }
}