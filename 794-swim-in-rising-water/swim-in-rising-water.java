class Solution {
   
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        boolean vis[][] = new boolean[n][n];
         vis[0][0] = true;

        pq.offer(new int[]{grid[0][0], 0, 0});

        int dir[][]={{0,-1},{0, 1},{-1,0}, {1,0}};
        int maxEle = 0;
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int Ele = curr[0];
            int x = curr[1];
            int y = curr[2]; 

            maxEle = Math.max(Ele, maxEle);
            if(x == n-1 && y == n-1) return maxEle;

            for(int d[] : dir){
                int nx = x+d[0];
                int ny = y+d[1];

                if(nx >=0 && ny >=0 && nx < n && ny<n && !vis[nx][ny]){
                    pq.offer(new int[]{grid[nx][ny], nx, ny});
                    vis[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}
