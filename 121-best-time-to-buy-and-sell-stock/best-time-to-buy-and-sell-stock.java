class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];

        for(int i=1; i<prices.length; i++){
           if(prices[i] < buy){ //lowest buy day
            buy = prices[i];
           }

           //current profit 
           int profit = prices[i] - buy;

           maxProfit =Math.max(maxProfit, profit);
        
        }

        return maxProfit;
    }
}