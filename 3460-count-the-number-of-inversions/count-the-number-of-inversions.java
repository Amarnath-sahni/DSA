class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        final int MOD = 1_000_000_007;
        final int MAX_INV = 400;

        // req[i] = required number of inversions for prefix ending at i, or -1 if none
        int[] req = new int[n];
        Arrays.fill(req, -1);
        for (int[] r : requirements) {
            int end = r[0];
            int cnt = r[1];
            req[end] = cnt;
        }

        // Prefix of length 1 (i = 0) must have 0 inversions (no preceding elements)
        if (req[0] > 0) {
            return 0;
        }
        req[0] = 0;

        // dp[i][j] = # of permutations of length i+1 (0..i) with j inversions
        // i runs 0..n-1, j runs 0..MAX_INV
        long[][] dp = new long[n][MAX_INV + 1];

        dp[0][0] = 1;  // one way to place single element with 0 inversions

        for (int i = 1; i < n; i++) {
            // if there's a required count at position i, restrict to that
            int left = 0, right = MAX_INV;
            if (req[i] != -1) {
                left = req[i];
                right = req[i];
            }
            for (int inv = left; inv <= right; inv++) {
                long ways = 0;
                // For new position i, you can add k new inversions, where k ≤ i
                for (int k = 0; k <= Math.min(i, inv); k++) {
                    ways += dp[i - 1][inv - k];
                    if (ways >= MOD) ways %= MOD;
                }
                dp[i][inv] = ways % MOD;
            }
        }

        int finalReq = req[n - 1];
        if (finalReq < 0 || finalReq > MAX_INV) {
            // No valid requirement for the full permutation, or out of bounds
            return 0;
        }
        return (int)(dp[n - 1][finalReq] % MOD);
    }
}
