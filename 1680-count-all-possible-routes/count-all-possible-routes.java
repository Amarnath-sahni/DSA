class Solution {
     private static final int MOD = 1_000_000_007;

    int[] locations;
    int finish;
    int n;
    Integer[][] memo;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        this.locations = locations;
        this.finish = finish;
        this.n = locations.length;
        this.memo = new Integer[n][fuel + 1];

        return dfs(start, fuel);
    }

    private int dfs(int city, int fuel) {
        if (memo[city][fuel] != null) {
            return memo[city][fuel];
        }

        long ways = (city == finish) ? 1 : 0;

        for (int next = 0; next < n; next++) {
            if (next == city) continue;

            int cost = Math.abs(locations[city] - locations[next]);
            if (fuel >= cost) {
                ways += dfs(next, fuel - cost);
            }
        }

        memo[city][fuel] = (int) (ways % MOD);
        return memo[city][fuel];
    }
}