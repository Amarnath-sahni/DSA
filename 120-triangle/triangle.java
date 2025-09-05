class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1]; // extra space for easier calculation

        // Start from the bottom row and move upward
        for(int i=n-1; i>=0; i--){
            for(int col=0; col<triangle.get(i).size(); col++){
                dp[col] = Math.min(dp[col], dp[col+1]) + triangle.get(i).get(col);
            }
        }
        return dp[0]; // answer at the top
    }
}