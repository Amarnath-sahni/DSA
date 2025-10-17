class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            sum += nums[i];
        }

        if(sum % 2!=0) return false;
        int target = sum/2; 

        boolean dp[][] = new boolean[n+1][target+1]; //memoization
      //  for(int i=0; i<target; i++) dp[0][i] = true;
        for(int i=0; i<=n; i++) dp[i][0] = true;

        for(int i=1; i<=n; i++){
             int val = nums[i-1];

            for(int j=1; j<=target; j++){
                dp[i][j] = dp[i-1][j]; //not include

                if(j >= val){
                    dp[i][j] = dp[i][j] || dp[i-1][j-val];
                }
            }
        }

        return dp[n][target];
    }
}