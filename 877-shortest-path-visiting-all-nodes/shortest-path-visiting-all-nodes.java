class Solution {
    public int shortestPathLength(int[][] graph) {
      int n = graph.length;
      int finalBitmask = (1<<n)-1;

      Queue<int[]>q = new LinkedList<>();
      boolean vis[][] = new boolean[n][1<<n]; //

      // start bfs from multiple node
      for(int i = 0; i<n; i++){
        q.add(new int[]{i, 1<<i});
      }

      int steps = 0;

      while(!q.isEmpty()){
        int size = q.size();

        for(int i = 0; i<size; i++){
           int curr[] = q.poll();

           int node = curr[0];
           int marks = curr[1];

           //then masks == final bitmarks
           if(finalBitmask == marks) return steps;

           for(int neighbor : graph[node]){
            int newBitmask = marks | 1<<neighbor;

            if(!vis[neighbor][newBitmask]){
               vis[neighbor][newBitmask] = true;
               q.add(new int[]{neighbor, newBitmask}); 
            }
           }
        }
        steps++;
      }

      return -1; // you shoud not reach
    }
}