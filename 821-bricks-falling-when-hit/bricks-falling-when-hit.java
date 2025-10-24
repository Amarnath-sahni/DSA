class Solution {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int n = grid.length;
        int m = grid[0].length;
        int roof = n * m; // "roof" acts as the top node

        // step 1: copy the array
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = grid[i][j];
            }
        } // FIXED: removed extra closing brace

        // step 2: remove the hit bricks
        for (int[] hit : hits) { 
            int x = hit[0];
            int y = hit[1];
            if (arr[x][y] == 1) {
                arr[x][y] = 0;
            }
        }

        // step 3: make union-find and size arrays
        int[] par = new int[n * m + 1];
        int[] rank = new int[n * m + 1];

        for (int i = 0; i <= n * m; i++) { // FIXED: should start from 0, not 1
            par[i] = i;
            rank[i] = 1;
        }

        // step 4: connect the brick with adjacent ones
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    int id = i * m + j; // FIXED: was i*m + 1 (incorrect)

                    if (i == 0) union(par, rank, roof, id); // FIXED: added parameters

                    if (i > 0 && arr[i - 1][j] == 1) union(par, rank, id, (i - 1) * m + j);
                    if (j > 0 && arr[i][j - 1] == 1) union(par, rank, id, i * m + (j - 1));
                }
            }
        }

        // step 5: reverse the process
        int len = hits.length;
        int[] res = new int[len]; // FIXED: was "new res[len]" (invalid)

        for (int i = len - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == 0) continue;

            int id = x * m + y; // FIXED: was "i*m+j" (wrong variables)
            arr[x][y] = 1; // FIXED: need to restore brick before union

            int before = size(par, rank, roof);

            // connect up, down, left, right
            if (x == 0) union(par, rank, roof, id);
            if (x > 0 && arr[x - 1][y] == 1) union(par, rank, id, (x - 1) * m + y);
            if (x < n - 1 && arr[x + 1][y] == 1) union(par, rank, id, (x + 1) * m + y);
            if (y > 0 && arr[x][y - 1] == 1) union(par, rank, id, x * m + (y - 1));
            if (y < m - 1 && arr[x][y + 1] == 1) union(par, rank, id, x * m + (y + 1));

            int after = size(par, rank, roof);
            res[i] = Math.max(0, after - before - 1);
        }

        return res;
    }

    // FIXED: added parameters and corrected logic
    public static void union(int[] par, int[] rank, int i, int j) {
        int parA = find(par, i);
        int parB = find(par, j);

        if (parA == parB) return;

        if (rank[parA] >= rank[parB]) {
            par[parB] = parA;
            rank[parA] += rank[parB];
        } else {
            par[parA] = parB;
            rank[parB] += rank[parA];
        }
    }

    // FIXED: corrected recursion
    public static int find(int[] par, int x) {
        if (x != par[x]) {
            par[x] = find(par, par[x]);
        }
        return par[x];
    }

    // FIXED: changed definition to measure size by rank
    public static int size(int[] par, int[] rank, int x) {
        int root = find(par, x);
        return rank[root];
    }
}
