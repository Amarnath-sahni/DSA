class Solution {
    public int fib(int n) {
       int dp[] = new int[n+1];
       Arrays.fill(dp, -1);

       return solvedFib(dp, n);
    }

    public static int solvedFib(int[] dp, int n){
        if(n<=1) return n;
        if(dp[n] != -1) return dp[n];

      return solvedFib(dp, n-1) + solvedFib(dp, n-2);
    }
}