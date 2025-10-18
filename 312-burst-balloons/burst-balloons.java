class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

       int arr[] = new int[n+2]; 
       arr[0] = 1;
       arr[n+1] = 1;

       for(int i=0; i<n; i++){
           arr[i+1] = nums[i];
       }
     int dp[][] = new int[n+2][n+2];


      for(int len = 2; len<n+2; len++){ //find len = 2 ab

            for(int row=0; row+len<n+2; row++){ //row
                int col = row+len;

                for(int k = row+1; k<col; k++){
                    dp[row][col] = Math.max(dp[row][col],
                    arr[row]*arr[k]*arr[col] + dp[row][k] + dp[k][col]
                //bursting from ballon k +  left sub-interval + right sub-Interval
                    );
                }
            }
        }
        return dp[0][n+1];
    }
}