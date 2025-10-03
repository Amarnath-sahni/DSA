class Solution {
    public int snakesAndLadders(int[][] board) {
         int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(1); // start from square 1
        vis[1] = true;
        int steps = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.remove();
                if (curr == n * n) return steps; // reached end
                
                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n) continue;
                    
                    int[] pos = getCoordinates(next, n);
                    int row = pos[0], col = pos[1];
                    
                    if (board[row][col] != -1) {
                        next = board[row][col]; // ladder or snake
                    }
                    
                    if (!vis[next]) {
                        vis[next] = true;
                        q.add(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    // Convert square number -> (row, col) on board
    private int[] getCoordinates(int square, int n) {
        int row = n - 1 - (square - 1) / n;
        int col = (square - 1) % n;
        if (((n - 1 - row) % 2) == 1) {
            col = n - 1 - col;
        }
        return new int[]{row, col};
    }
}