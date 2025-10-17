class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            sum += nums[i];
        }

        if(sum % 2!=0) return false;
        int target = sum/2; 

        Boolean dp[][] = new Boolean[n][target+1]; //memoization
        return solve(nums, 0, target, dp);
    }

    private static boolean solve(int nums[], int i, int target, Boolean[][] dp){
       if(target == 0) return true;

       if(i>= nums.length  || target < 0) return false;

        if (dp[i][target] != null) return dp[i][target];

       boolean include = solve(nums, i+1, target-nums[i], dp);
       boolean exclude = solve(nums, i+1, target, dp);

       dp[i][target] = include || exclude;
       return dp[i][target];
    }
}