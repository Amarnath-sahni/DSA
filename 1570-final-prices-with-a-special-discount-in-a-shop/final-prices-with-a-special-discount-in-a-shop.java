class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int arr[] = prices.clone();
        Stack<Integer>s = new Stack<>();

        for(int i=0; i<n; i++){
            //check discount
           while(!s.isEmpty() && prices[i] <= prices[s.peek()]){
            int idx =  s.pop();
            arr[idx] = prices[idx] - prices[i];
           }
           s.push(i);
        }

      return arr;
    }
}