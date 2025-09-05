class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[n][m];

        dp[0][0] = grid[0][0];
        for(int j=1; j<m; j++){ //fill col
           dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for(int i=1; i<n; i++){ //row
           dp[i][0] = dp[i-1][0] + grid[i][0];
        }
     
        for(int i=1; i<n; i++){
            for(int col=1; col<m; col++){
               dp[i][col] = grid[i][col] + Math.min(dp[i-1][col] , dp[i][col-1]);
            }
        }
        return dp[n-1][m-1]; 
    }    
}