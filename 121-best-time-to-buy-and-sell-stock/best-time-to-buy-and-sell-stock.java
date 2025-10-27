class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxP = 0;

        int prev = prices[0];
        for(int i=1; i<n; i++){

            if(prev < prices[i] ){
                maxP = Math.max(maxP, prices[i]-prev);
            }else{
                prev = prices[i];
            }
  
        }

        return maxP;
    }
}